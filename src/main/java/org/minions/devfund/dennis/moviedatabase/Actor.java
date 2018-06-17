package org.minions.devfund.dennis.moviedatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the methods for Actor class.
 */
public class Actor {
    private String name;
    private List<Movie> movies;

    /**
     * Constructor for Actor.
     * @param name of actor
     */
    public Actor(final String name) {
        this.name = name;
        movies = new ArrayList<>();
    }

    /**
     * Default values for Constructor.
     */
    public Actor() {
        this("");
    }

    /**
     * Get name of actor.
     * @return get the name
     */
    public String getName() {
        return name;
    }

    /**
     * set the name in the list.
     * @param name of actor
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * get all movies of actor.
     * @return arrayList of the movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Set the movies in the array list.
     * @param movies capture the name of movie
     */
    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Generate the actor rating.
     * @return get the actor rating
     */
    public double getActorRating() {
        double ratingSum = 0;
        for (Movie movie : movies) {
            ratingSum += movie.getRating();
        }
        return ratingSum / movies.size();
    }
}
