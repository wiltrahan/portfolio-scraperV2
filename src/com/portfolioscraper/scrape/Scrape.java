package com.portfolioscraper.scrape;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.portfolioscraper.dao.DateTimeDAOImpl;
import com.portfolioscraper.entity.DateTime;

public class Scrape implements IScrape {
	
	private static WebDriver driver;
	
	
	public static void main(String[] args) {
		
		driver = new FirefoxDriver();
		
		Personal personal = new Personal();
		String username = personal.getUsername();
		String password = personal.getPassword();
		
		Scrape scrape = new Scrape();
		scrape.login(username, password);
	}
	
	private void login(String username, String password) {
		String logScreen = "https://login.yahoo.com/config/login?.done=https%3A%2F%2Ffinance.yahoo.com%2Fportfolios&.intl=us&.lang=en-US&.src=finance";
		driver.get(logScreen);
		
		try {
			driver.findElement(By.id("login-username")).sendKeys(username);
			driver.findElement(By.id("login-signin")).click();
			Thread.sleep(3000);
			pass(password);
		} catch (Exception e) {
			System.out.println("Login Failed: " + e.getMessage());
		}	
	}
	
	private void pass(String password) {
		try {
			driver.findElement(By.id("login-passwd")).sendKeys(password);
			driver.findElement(By.id("login-signin")).click();
			Thread.sleep(2000);
			toYahooPortfolio();
		} catch (Exception e) {
			System.out.println("Password Failed: " + e.getMessage());
		}
	}
	
	private void toYahooPortfolio() {
		try {
			driver.navigate().to("https://finance.yahoo.com/portfolio/p_0/view/v1");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/dialog/section/button")).click();
			valueScrape();
		} catch (Exception e) {
			System.out.println("To Portfolio Failed: " + e.getMessage());
		}
	}
	
	public static void valueScrape() throws ParseException {
		DateTimeDAOImpl dateTimeDAOImpl = new DateTimeDAOImpl();
		String date = dateTimeDAOImpl.currentDate();
		String time = dateTimeDAOImpl.currentTime();
        
		String portfolioTotal = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/header/div/div[1]/div/div[2]/p[1]")).getText();
        String dayGain = driver.findElement(By.xpath("/html/body/div[2]/div[3]/section/header/div/div[1]/div/div[2]/p[2]/span")).getText();

		
//		return new DateTime(date, time, portfolioTotal, dayGain);
        dateTimeDAOImpl.insertDateTimes(new DateTime(date, time, portfolioTotal, dayGain));
		
	}
	

}
