package org.java.eventi;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event {
	private LocalTime Hour;
	private BigDecimal price;
	
	public Concert(String title, LocalDate date, int totalSpots, LocalTime Hour, BigDecimal price) throws Exception {
		super(title, date, totalSpots);
		setHour(Hour);
		setPrice(price);
	}

	public LocalTime getHour() {
		return Hour;
	}

	public void setHour(LocalTime hour) {
		Hour = hour;
	}

	public String getPrice() {
		return NumberFormat.getCurrencyInstance().format(price);
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Concert: " + getDate() + " / " + Hour + " - " + getTitle() + " - " + getPrice();
	}
}
