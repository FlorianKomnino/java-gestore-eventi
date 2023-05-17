package org.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to your event manager");
		
		try {
			Helper.newEventCreator();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception: " + e);
		}
	}
}
