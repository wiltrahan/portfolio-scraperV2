package com.portfolioscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolioscraper.springdemo.entity.DateTime;
import com.portfolioscraper.springdemo.service.DateTimeService;

@Controller
@RequestMapping("/date")
public class DateController {
	

	//inject date service
	@Autowired
	private DateTimeService dateTimeService;
	
	@GetMapping("/list")
	public String listDateTime(Model theModel) {
		
		//get dates and time from service
		List<DateTime> theDates = dateTimeService.getDateTimes();
			
		//add dates to model
		theModel.addAttribute("dates", theDates);
		
		return "list-date";
	}
}
