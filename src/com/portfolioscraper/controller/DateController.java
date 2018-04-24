package com.portfolioscraper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/date")
public class DateController {
	
	@RequestMapping("/list")
	public String listDateTime(Model theModel) {
		
		return "list-date";
	}
}
