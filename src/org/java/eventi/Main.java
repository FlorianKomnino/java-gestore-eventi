package org.java.eventi;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			Helper.newEventCreator();	
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception: " + e);
		}
	}
}
