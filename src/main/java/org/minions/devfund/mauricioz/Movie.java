package org.minions.devfund.mauricioz;

import java.util.ArrayList;
import java.util.List;

/**
 * Movie Class definition.
 */
public class Movie {
    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     * Constructor.
     * @param name movie name.
     */
    public Movie(final String name) {
        this.name = name;
        this.actors = new ArrayList<>();
    }

    /**
     * get movie name.
     * @return movie name.
     */
    public String getName() {
        return name;
    }

    /**
     * setting a movie name.
     * @param name new movie name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * getting a list of actors of a movie.
     * @return list of actors.
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * adding an actor to the movie.
     * @param actors Actor to be added to the movie.
     */
    public void setActors(final List<Actor> actors) {
        this.actors = actors;
    }

    /**
     * getting the movie rating.
     * @return movie rating.
     */
    public double getRating() {
        return rating;
    }

    /**
     * setting the movie rating.
     * @param rating set the movie rating.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }
}
