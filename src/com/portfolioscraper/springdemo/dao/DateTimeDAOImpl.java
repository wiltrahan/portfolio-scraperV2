package com.portfolioscraper.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolioscraper.springdemo.entity.DateTime;

@Repository
public class DateTimeDAOImpl implements DateTimeDAO {

	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
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
	
	public static void main(String[] args) {
		DateTimeDAOImpl dateTimeDAOImpl = new DateTimeDAOImpl();
		
		dateTimeDAOImpl.insertDateTimes();
		
		//insertDateTimes();
	}

	@Override
	public void insertDateTimes() {
		
		sessionFactory = new Configuration()
									.configure()
									.addAnnotatedClass(DateTime.class)
									.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//create date time object
			DateTime tempDate = new DateTime("4-26-18", "3:55pm", "$555.432.32", "+2,325.23 (+1.22%)");
			
			//start transaction
			session.beginTransaction();
			
			//save date time object
			session.save(tempDate);
			
			//commit transaction
			session.getTransaction().commit();
			
		} finally {
			sessionFactory.close();
		}
		
		//return null;
	}

}
