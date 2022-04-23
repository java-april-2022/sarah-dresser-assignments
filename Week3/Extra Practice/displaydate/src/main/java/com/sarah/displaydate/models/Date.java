package com.sarah.displaydate.models;

public class Date {
	// MEMBER VARIABLES
	private String month;
	private int day;
	private int year;
	
	// CONSTRUCTOR
	public Date(String month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	// GETTERS & SETTERS
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
