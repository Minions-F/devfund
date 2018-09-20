package org.minions.devfund.ronald.sd2x.hw8;/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataTier {
	
	private String fileName; // the name of the file to read
	private List<Book> books;
	public DataTier(String inputSource) {
		fileName = inputSource;
		books = new ArrayList<>();
		readFile();
	}


	public List<Book> getAllBooks() {
		return books;
	}


	private void readFile() {
		if (fileName != null && !fileName.isEmpty()) {
			try {
				Scanner scanner = new Scanner(new File(fileName));
				scanner = scanner.useDelimiter("\\t");
				while (scanner.hasNext()){
					String[] currentLine = scanner.nextLine().split("\\t");
					Book book = new Book(currentLine[0], currentLine[1], Integer.valueOf(currentLine[2]));
					books.add(book);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
