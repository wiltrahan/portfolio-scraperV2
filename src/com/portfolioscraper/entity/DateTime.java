package com.portfolioscraper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="date_time")
public class DateTime {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="total")
	private String total;
	
	@Column(name="dayGain")
	private String dayGain;
	
	@Column(name="date_time_id")
	private int date_time_id;
	
	public DateTime() {
		
	}

	public DateTime(String date, String time, String total, String dayGain) {
		
		this.date = date;
		this.time = time;
		this.total = total;
		this.dayGain = dayGain;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDayGain() {
		return dayGain;
	}

	public void setDayGain(String dayGain) {
		this.dayGain = dayGain;
	}
	
	public int getDate_time_id() {
		return date_time_id;
	}

	public void setDate_time_id(int date_time_id) {
		this.date_time_id = date_time_id;
	}

	@Override
	public String toString() {
		return "DateTime [id=" + id + ", date=" + date + ", time=" + time + ", total=" + total + ", dayGain=" + dayGain
				+ "]";
	}
	
}
