package org.minions.devfund.ronald.sd2x.hw8;/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

import java.util.ArrayList;
import java.util.List;

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}


	public List<String> findBookTitlesByAuthor(String author) {
		List<Book> books = dataTier.getAllBooks();
		List<String> booksFound = new ArrayList<>();
		for (Book book : books) {
			if (book.getAuthor().contains(author)) {
				booksFound.add(book.getTitle());
			}
		}
		return booksFound;
	}

	public int findNumberOfBooksInYear(int year) {
		List<Book> books = dataTier.getAllBooks();
		Long published =  books.stream().filter((it)-> it.getPublicationYear() == year).count();

		return published.intValue();
	}
	

}
