package org.minions.devfund.ronald.sd2x.hw5;/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class MovieRatingsProcessor {

	/**
	 * List of movie titles in alphabetical order.
	 *
	 * @param movieRatings value
	 * @return a List of movie titles in alphabetical order
	 */
	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		if (movieRatings == null || movieRatings.isEmpty()) {
			return new ArrayList<>();
		}

		return new ArrayList<>(movieRatings.keySet());
	}

	/**
	 * given an input int rating, return a List of movie titles in alphabetical order, where all movies in the List
	 * do not have any ratings less than or equal to rating (hint: the PriorityQueue is a min-heap, meaning that the
	 * smallest rating is at the front of the queue!).
	 *
	 * @param movieRatings
	 * @param rating
	 * @return
	 */
	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		List<String> alphabeticalMoviesAboveRating = new ArrayList<>();
		if (movieRatings == null || movieRatings.isEmpty()) {
			return alphabeticalMoviesAboveRating;
		}

		for (String title : movieRatings.keySet()) {
			if (movieRatings.get(title).peek() > rating) {
				alphabeticalMoviesAboveRating.add(title);
			}
		}
		
		return alphabeticalMoviesAboveRating;
	}

	/**
	 * given an input int rating, modify the TreeMap object that was passed as an argument so that you remove all
	 * ratings in the PriorityQueue that are below (but not equal to) rating for every movie in the Map. If all ratings
	 * are removed from a movie’s PriorityQueue, then remove the mapping from the TreeMap. Additionally, this method
	 * should return a new TreeMap that maps a movie title to the number of ratings that were removed from its
	 * corresponding PriorityQueue; the TreeMap that is returned should only contain movies that had ratings
	 * removed from its PriorityQueue.
	 *
	 * @param movieRatings map
	 * @param rating value
	 * @return should only contain movies that had ratings removed from its PriorityQueue.
	 */
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		TreeMap<String, Integer> ratingsRemoved = new TreeMap<>();
		if (movieRatings == null || movieRatings.isEmpty()) {
			return ratingsRemoved;
		}

		Iterator<Map.Entry<String, PriorityQueue<Integer>>> iterator = movieRatings.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, PriorityQueue<Integer>> current = iterator.next();
			if (current.getValue().peek() >= rating) continue;

			List<Integer> remove = new ArrayList<>();
			for (Integer ratingValue : current.getValue()) {
				if (ratingValue < rating)
					remove.add(ratingValue);
			}

			current.getValue().removeAll(remove);
			ratingsRemoved.put(current.getKey(), remove.size());

			if (current.getValue().size() == 0) {
				iterator.remove();
			}

		}

		return ratingsRemoved;
	}
}
