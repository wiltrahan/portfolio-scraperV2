package com.portfolioscraper.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portfolioscraper.entity.DateTime;
import com.portfolioscraper.entity.Stock;

public interface DateTimeDAO {

	public List<DateTime> getDateTimes();
	
	//public List<Stock> getStocks(int id);
	
	public void insertDateTimes(DateTime datetime) throws ParseException;
		
	public String currentDate() throws ParseException;
	
	public String currentTime() throws ParseException;

	String formatTime(String time) throws ParseException;

	public List<Stock> getStocks(int id);

	//List<Stock> getStocks(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException;
	
}
