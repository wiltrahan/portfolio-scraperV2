package com.portfolioscraper.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	
	
	

}
