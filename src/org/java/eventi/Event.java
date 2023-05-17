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
		}
	}
	public void removeReservation() {
		if(reservations > 0 && myNow.isBefore(date)) {
			reservations--;
		}
	}
	
	public void reservationsSetter(int resNum) {
		if (resNum > 0 && resNum < getTotalSpots() - getReservations()) {
			for (int i=0; i< resNum; i++) {
				addReservation();
			}
			System.out.println("Reservations added succesfully!");
		} else {
			System.out.println("It's impossible to add that number of reservations");
		}
	}
	
	public void reservationsRemover(int resNum) {
		if (resNum > 0 && resNum < getReservations()) {
			for (int i=0; i< resNum; i++) {
				removeReservation();
			}
			System.out.println("Reservations removed succesfully!");
		} else {
			System.out.println("It's impossible to remove that number of reservations");
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Event: " + date + " - " + title;
	}
}
