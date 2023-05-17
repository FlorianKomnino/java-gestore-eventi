package org.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Helper {
	
	public static void newEventCreator() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert the number of total available spots of your event");
		int totalSpots = sc.nextInt();
		
		System.out.println("Insert the date in the format yyyy-MM-dd");
		sc.nextLine();
		String dateString = sc.nextLine();
		LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
		if (date.isBefore(LocalDate.now())) {
			throw new Exception("It's not possible to add an event in that date.");
		}
		
		System.out.println("Insert the event title");
		String eventTitle = sc.nextLine();
		
		Event eventTest = new Event(eventTitle, date, totalSpots);
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
		
		System.out.println("The number of reservations is: " + eventTest.getReservations());
		System.out.println("The number of still available spots is: " + (eventTest.getTotalSpots() - eventTest.getReservations()));
		
	}
	

	
	
}
