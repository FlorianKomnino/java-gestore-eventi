package org.java.eventi;

import java.time.LocalDate;

public class Event {
	private String title;
	private LocalDate date;
	private int totalSpots;
	private int reservations;
	
	public Event(String title, LocalDate date, int totalSpots) {
		setTitle(title);
		setDate(date);
		setTotalSpots(totalSpots);
		setReservations(0);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getTotalSpots() {
		return totalSpots;
	}

	public void setTotalSpots(int totalSpots) {
		this.totalSpots = totalSpots;
	}

	public int getReservations() {
		return reservations;
	}

	public void setReservations(int reservations) {
		this.reservations = reservations;
	}
}
