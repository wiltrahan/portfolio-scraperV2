package com.portfolioscraper.springdemo.dao;

import java.text.ParseException;
import java.util.List;

import com.portfolioscraper.springdemo.entity.DateTime;

public interface DateTimeDAO {

	public List<DateTime> getDateTimes();
	
	public void insertDateTimes() throws ParseException;
		
	public String currentDate() throws ParseException;
	
	public String currentTime() throws ParseException;

	String formatTime(String time) throws ParseException;
	
}
