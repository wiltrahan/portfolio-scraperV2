package com.portfolioscraper.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolioscraper.springdemo.dao.DateTimeDAO;
import com.portfolioscraper.springdemo.entity.DateTime;

@Service
public class DateTimeServiceImpl implements DateTimeService {
	
	//inject Date Time DAO
	@Autowired
	DateTimeDAO dateTimeDAO;

	@Override
	@Transactional
	public List<DateTime> getDateTimes() {
		
		return dateTimeDAO.getDateTimes();
	}

}
