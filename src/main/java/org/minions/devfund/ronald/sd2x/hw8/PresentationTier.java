package org.minions.devfund.ronald.sd2x.hw8;/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

import java.util.List;
import java.util.Scanner;

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	private Scanner scanner;
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
		scanner = new Scanner(System.in);
	}
	
	public void start() {
		System.out.println("Please select search option:");
		System.out.println("1. Find books by Author.");
		System.out.println("2. Find number of books per Year.");
		String input = scanner.nextLine();

		if (input.contains("1")) {
			showBookTitlesByAuthor();
		} else if (input.contains("2")) {
			showNumberOfBooksInYear();
		} else {
			System.out.println("Wrong Input");
		}
	}

	public void showBookTitlesByAuthor() {
		System.out.println("------- Show hw8.Book(s) title by Author -------");
		System.out.println("Please insert Author given name:");
		String authorName = scanner.nextLine();
		List<String> titles = logicTier.findBookTitlesByAuthor(authorName);
		titles.forEach(System.out::println);
	}


	public void showNumberOfBooksInYear() {
		System.out.println("------- Show Number of hw8.Book(s) per Year -------");
		System.out.println("Please insert given Year:");
		int year = scanner.nextInt();
		int count = logicTier.findNumberOfBooksInYear(year);
		System.out.println("Number of Books published on " + String.valueOf(year) + ": " + String.valueOf(count));
	}
}
