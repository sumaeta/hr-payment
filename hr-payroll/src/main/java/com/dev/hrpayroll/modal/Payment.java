package com.dev.hrpayroll.modal;

import java.io.Serializable;

public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Double dailyicome;
	private Integer days;

	public Payment() {
		super();
	}

	public Payment(String name, Double dailyicome, Integer days) {
		super();
		this.name = name;
		this.dailyicome = dailyicome;
		this.days = days;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyicome() {
		return dailyicome;
	}

	public void setDailyicome(Double dailyicome) {
		this.dailyicome = dailyicome;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public double getTotal() {
		return days * dailyicome;
	}

}
