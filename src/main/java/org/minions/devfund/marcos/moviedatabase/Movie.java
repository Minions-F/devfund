package org.minions.devfund.marcos.moviedatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * It is in charged to represent a movie an it is properties.
 */
public class Movie {

    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     * Initializes an instance of {@link Movie}.
     *
     * @param name movie's name value.
     */
    public Movie(final String name) {
        this.name = name;
        actors = new ArrayList<>();
        rating = 0.0;
    }

    /**
     * Initializes an instance of {@link Movie}.
     */
    public Movie() {
        this("");
    }

    /**
     * Gets the movie's name attribute value.
     *
     * @return movie's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the movie'es name attribute value.
     *
     * @param name new movie's name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the entire movie's actors list.
     *
     * @return movie's actors list.
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * Sets the movie's actors list.
     *
     * @param actors new movie's actors list.
     */
    public void setActors(final List<Actor> actors) {
        this.actors = actors;
    }

    /**
     * Gets the movie's rating value.
     *
     * @return movie's rating.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the movie's rating value.
     *
     * @param rating new movie's rating.
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }
}
