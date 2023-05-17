package org.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Helper {
	
	public static LocalDate getDateFromUser() throws Exception {
		Scanner dateSc = new Scanner(System.in);
		System.out.println("Insert the date in the format yyyy-MM-dd");
		dateSc.nextLine();
		String dateString = dateSc.nextLine();
		LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
		dateSc.close();
		if (date.isBefore(LocalDate.now())) {
			throw new Exception("It's not possible to add an event in that date.");
		} else {			
			System.out.println("Ha funzionato");
		}
		return date;
	}
	
	public static void newEventCreator() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert the number of total available spots of your event");
		int totalSpots = sc.nextInt();

		LocalDate eventDate = null;
		
		Scanner dateSc = new Scanner(System.in);
		System.out.println("Insert the date in the format yyyy-MM-dd");
		String dateString = dateSc.nextLine();
		LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
		dateSc.close();
		if (date.isBefore(LocalDate.now())) {
			throw new Exception("It's not possible to add an event in that date.");
		} else {			
			System.out.println("Ha funzionato");
		}
		
		System.out.println("Insert the event title");
		sc.next();
		String eventTitle = sc.nextLine();
		sc.close();
		
		Event eventTest = new Event(eventTitle, date, totalSpots);
		System.out.println(eventTest);
		
	}
	
	public static void evSetterOptions() {
		System.out.println("Do you wish to modify your event?");
		System.out.println("1 - add reservations");
		System.out.println("2 - remove reservations");
		System.out.println("3 - change the title");
		System.out.println("4 - change the date");
		System.out.println("5 - exit from event setter");		
	}
	
	public static Integer eventSetterChoice() {
		Scanner sc = new Scanner(System.in);
		Integer evSetChoice = sc.nextInt();
		sc.close();
		return evSetChoice;
	}
	
	
	
	
}
