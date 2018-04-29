package com.portfolioscraper.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolioscraper.entity.DateTime;
import com.portfolioscraper.entity.Stock;
import com.portfolioscraper.service.DateTimeService;

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
	
	@GetMapping("/portfolio")
	public String showPortfolio(@RequestParam("dateId") int theId,
								Model theModel) {
		
		// get stocks from database
		List<Stock> theStocks = dateTimeService.getStocks();
		//List<Stock> theStocks = new ArrayList<Stock>();
//		theStocks.add(new Stock("GE", "14.34", "-0.04", "-0.28%", "500.00"));
//		theStocks.add(new Stock("TSLA", "293.24", "+7.76", "+2.72%", "600.00"));
//		theStocks.add(new Stock("GOOG", "1027.99", "-12.05", "-1.16%", "50.00"));
		
		//set stock list as a model attribute
		theModel.addAttribute("stocks", theStocks);
		
		// send over to jsp page
		
		return "portfolio-date";
	}
}
