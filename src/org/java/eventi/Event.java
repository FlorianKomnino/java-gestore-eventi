package org.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Event {
	private String title;
	private LocalDate date;
	private int totalSpots;
	private int reservations;
	
	private LocalDate myNow = LocalDate.now();
	
	public Event(String title, LocalDate date, int totalSpots) throws Exception {
		if (title != "") {
			setTitle(title);
		} else {
			throw new Exception("The title cannot be empty");
		}
		setDate(date);
		this.totalSpots = totalSpots;
		this.reservations = 0;
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
	public int getReservations() {
		return reservations;
	}
	
	public void addReservation() {
		if(totalSpots > reservations && myNow.isBefore(date)) {
			reservations++;
			System.out.println("Your reservation has been added succesfully!");
		} else {
			System.err.println("Sorry, something went wrong!");
		}
	}
	public void removeReservation() {
		if(reservations > 0 && myNow.isBefore(date)) {
			reservations--;
			System.out.println("Your reservation has been removed succesfully!");
		} else {
			System.err.println("Sorry, something went wrong!");
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Event: " + date + " - " + title;
	}
}
