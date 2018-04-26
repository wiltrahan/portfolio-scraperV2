package com.portfolioscraper.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.portfolioscraper.entity.DateTime;
import com.portfolioscraper.entity.Portfolio;




@Repository
public class DateTimeDAOImpl implements DateTimeDAO {

	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
//	
//	public static void main(String[] args) throws ParseException {
//		DateTimeDAOImpl dateTimeDAOImpl = new DateTimeDAOImpl();
//		
//		dateTimeDAOImpl.insertDateTimes();
//		
//	}
	
	@Override
	public List<DateTime> getDateTimes() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<DateTime> theQuery = 
				currentSession.createQuery("from DateTime", DateTime.class);
		
		//execute query and get result list
		List<DateTime> dateTimes = theQuery.getResultList();
			
		//return results	
		return dateTimes;
	}

	public void insertDateTimes(DateTime dateTime) throws ParseException {
		
		sessionFactory = new Configuration()
									.configure()
									.addAnnotatedClass(DateTime.class)
									.addAnnotatedClass(Portfolio.class)
									.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//create date time object
			DateTime tempDate = dateTime;
			//create portfolio object
			Portfolio tempPortfolio = 
					new Portfolio("TSLA", "333.30", "-1.47", "-0.44%", "600.00", "NULL", "NULL");
			
			//associate the objects
			tempDate.setPortfolio(tempPortfolio);
			
			
			//start transaction
			session.beginTransaction();
			
			//save date time object
			//this also saves Portfolio object because of CascadeType.ALL
			session.save(tempDate);
			
			//commit transaction
			session.getTransaction().commit();
			
		} finally {
			sessionFactory.close();
		}
		
	}


	public String currentDate() throws ParseException {
		
		String dateTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		String[] timeSplit = dateTime.split("\\s+");

		return timeSplit[0];
	}

	@Override
	public String currentTime() throws ParseException {
		
		String dateTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		String[] timeSplit = dateTime.split("\\s+");
		
		return formatTime(timeSplit[1]);

	}

	@Override
	public String formatTime(String time) throws ParseException {
		//old format
	    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	    Date timeFormat = sdf.parse(time);
	    //new format
	    SimpleDateFormat sdf2 = new SimpleDateFormat("h:mm aa");
	    //formatting the given time to new format with AM/PM
	    return sdf2.format(timeFormat);
		
	}
}
