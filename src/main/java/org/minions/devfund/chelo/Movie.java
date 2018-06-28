package org.minions.devfund.chelo;

import java.util.ArrayList;

/**
 * Movie class.
 */
public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    /**
     * Movie constructor.
     * @param name name.
     */
    public Movie(final String name) {
        this.name = name;
        this.rating = 0.0;
        actors = new ArrayList<>();
    }

    /**
     * Movie constructor.
     */
    public Movie() {
        this("");
    }

    /**
     * Getter for movie name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for Movie name.
     * @param name name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter for actor list.
     * @return actors.
     */
    public ArrayList<Actor> getActors() {
        return actors;
    }

    /**
     * Setter for actors.
     * @param actors actors.
     */
    public void setActors(final ArrayList<Actor> actors) {
        this.actors = actors;
    }

    /**
     * Getter for rating.
     * @return rating.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Setter for rating.
     * @param rating rating.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }
}
