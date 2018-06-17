package org.minions.devfund.dennis.moviedatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the methods for Movie class.
 */
public class Movie {
    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     * Constructor for Movie.
     * @param name of Movie
     */
    public Movie(final String name) {
        this.name = name;
        this.rating = 0.0;
        actors = new ArrayList<>();
    }

    /**
     * Default values for Constructor.
     */
    public Movie() {
        this("");
    }

    /**
     * Get name of Movie.
     * @return name of movie
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the movie.
     * @param name of movie
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get rating of movie.
     * @return rating of movie
     */
    public double getRating() {
        return rating;
    }

    /**
     * Set the rating of movie.
     * @param rating of the movie
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }

    /**
     * Get the all Actors for the movie.
     * @return the actors
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * Set the actors for the movies.
     * @param actors in the array
     */
    public void setActors(final List<Actor> actors) {
        this.actors = actors;
    }
}
