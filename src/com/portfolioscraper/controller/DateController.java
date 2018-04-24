package com.portfolioscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolioscraper.springdemo.dao.DateTimeDAO;
import com.portfolioscraper.springdemo.entity.DateTime;

@Controller
@RequestMapping("/date")
public class DateController {
	
	//inject the date time dao
	@Autowired
	private DateTimeDAO dateTimeDAO;
	
	@RequestMapping("/list")
	public String listDateTime(Model theModel) {
		
		//get dates and time from dao
		List<DateTime> theDates = dateTimeDAO.getDateTimes();
		
		
		//add dates to model
		theModel.addAttribute("dates", theDates);
		
		return "list-date";
	}
}
