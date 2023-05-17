package org.java.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Helper {

//	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
	
	public static void newEventCreator() throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Welcome to your events manager");
		
		System.out.println("What kind of event do you want to create?");
		String typeOfEvent = sc.nextLine();
		
		LocalTime eventHourPars = null;
		BigDecimal bigDecEventPrice = null;
		if (typeOfEvent.toLowerCase().equals("concert")) {
			System.out.println("Insert the price of you event");
			float eventPrice = sc.nextFloat();
			bigDecEventPrice = BigDecimal.valueOf(eventPrice);
			System.out.println("Insert the hour of your event in \"HH:mm\" format: ");
			sc.nextLine();
			String eventHour = sc.nextLine();
			eventHourPars = LocalTime.parse(eventHour);
			
		}
		
		System.out.println("Insert the date in the format yyyy-MM-dd");
		String dateString = sc.nextLine();
		LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
		if (date.isBefore(LocalDate.now())) {
			throw new Exception("It's not possible to add an event in that date.");
		}
		
		System.out.println("Insert the number of total available spots of your " + typeOfEvent + ": ");
		int totalSpots = sc.nextInt();

		System.out.println("Insert the " + typeOfEvent + " title");
		String eventTitle = sc.nextLine();
		
		Event eventTest;
		if (typeOfEvent.toLowerCase().equals("concert")) {
			eventTest = new Concert(eventTitle, date, totalSpots, eventHourPars, bigDecEventPrice);
		} else {
			eventTest = new Event(eventTitle, date, totalSpots);
		}
		System.out.println(eventTest);

		System.out.println("Do you want to add some reservations?");
		System.out.println("1 - yes");
		System.out.println("2 - no");
		
		int opChoice = sc.nextInt();
		if (opChoice < 1 && opChoice > 2) {
			System.out.println("Sorry, choice not found!");
		} else if (opChoice == 1) {
			System.out.println("How many reservations you want to add?");
			int resNum = sc.nextInt();
			eventTest.reservationsSetter(resNum);
		} else if (opChoice == 2) {
			System.out.println("Ok let's go on...");
		}
		
		System.out.println("Do you want to remove some reservations?");
		System.out.println("1 - yes");
		System.out.println("2 - no");
		
		int removeChoice = sc.nextInt();
		if (removeChoice < 1 && removeChoice > 2) {
			System.out.println("Sorry, choice not found!");
		} else if (removeChoice == 1) {
			System.out.println("How many reservations you want to remove?");
			int resNum = sc.nextInt();
			eventTest.reservationsRemover(resNum);
		} else if (removeChoice == 2) {
			System.out.println("Ok we're done! :)");
		}
		
		sc.close();
		
		System.out.println("The number of reservations is: " + eventTest.getReservations());
		System.out.println("The number of still available spots is: " + (eventTest.getTotalSpots() - eventTest.getReservations()));
		
	}
	

	
	
}
