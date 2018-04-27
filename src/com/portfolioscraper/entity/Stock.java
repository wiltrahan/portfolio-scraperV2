package com.portfolioscraper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="value")
	private String value;
	
	@Column(name="dayAmtChg")
	private String dayAmtChg;
	
	@Column(name="dayPctChg")
	private String dayPctChg;
	
	@Column(name="totalShrs")
	private String totalShrs;
	
	@Column(name="portfolioTotal")
	private String portfolioTotal;
	
	@Column(name="portfolioDayGain")
	private String portfolioDayGain;
	
	
	public Stock() {
		
	}

	public Stock(String symbol, String value, String dayAmtChg, String dayPctChg, String totalShrs,
			String portfolioTotal, String portfolioDayGain) {
		this.symbol = symbol;
		this.value = value;
		this.dayAmtChg = dayAmtChg;
		this.dayPctChg = dayPctChg;
		this.totalShrs = totalShrs;
		this.portfolioTotal = portfolioTotal;
		this.portfolioDayGain = portfolioDayGain;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDayAmtChg() {
		return dayAmtChg;
	}

	public void setDayAmtChg(String dayAmtChg) {
		this.dayAmtChg = dayAmtChg;
	}

	public String getDayPctChg() {
		return dayPctChg;
	}

	public void setDayPctChg(String dayPctChg) {
		this.dayPctChg = dayPctChg;
	}

	public String getTotalShrs() {
		return totalShrs;
	}

	public void setTotalShrs(String totalShrs) {
		this.totalShrs = totalShrs;
	}

	public String getPortfolioTotal() {
		return portfolioTotal;
	}

	public void setPortfolioTotal(String portfolioTotal) {
		this.portfolioTotal = portfolioTotal;
	}

	public String getPortfolioDayGain() {
		return portfolioDayGain;
	}

	public void setPortfolioDayGain(String portfolioDayGain) {
		this.portfolioDayGain = portfolioDayGain;
	}

	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", symbol=" + symbol + ", value=" + value + ", dayAmtChg=" + dayAmtChg
				+ ", dayPctChg=" + dayPctChg + ", totalShrs=" + totalShrs + ", portfolioTotal=" + portfolioTotal
				+ ", portfolioDayGain=" + portfolioDayGain + "]";
	}	
	
}
