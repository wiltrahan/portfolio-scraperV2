package com.portfolioscraper.springdemo.dao;

import java.util.List;

import com.portfolioscraper.springdemo.entity.DateTime;

public interface DateTimeDAO {

	public List<DateTime> getDateTimes();
	
	public void insertDateTimes();
	
}
