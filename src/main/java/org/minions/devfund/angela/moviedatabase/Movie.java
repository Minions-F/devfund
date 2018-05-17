package org.minions.devfund.angela.moviedatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the movie object.
 */
public class Movie {

    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     * Constructor of {@link Movie}.
     *
     * @param newName   String the movie name.
     */
    public Movie(final String newName) {
        name = newName;
        actors =  new ArrayList<>();
    }

    /**
     * Gets the movie name.
     *
     * @return String the movie name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the movie name.
     *
     * @param name the new movie name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the list of actors in the movie.
     *
     * @return the list of the actors.
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * Sets the list of the actors in the movie.
     *
     * @param actors the list of the actors.
     */
    public void setActors(final List<Actor> actors) {
        this.actors = actors;
    }

    /**
     * Gets the movie rating.
     *
     * @return double the movie rating.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the movie rating.
     *
     * @param newRating the new movie rating
     */
    public void setRating(final double newRating) {
        this.rating = newRating;
    }
}
