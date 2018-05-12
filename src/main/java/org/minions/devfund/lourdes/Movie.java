package org.minions.devfund.lourdes;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that define the Movie entity.
 */
public class Movie {
    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     * Constructor that receive the Movie Name.
     *
     * @param name represents the movie name.
     */
    public Movie(final String name) {
        this.name = name;
        this.actors = new ArrayList<>();
    }

    /**
     * Constructor.
     */
    public Movie() {
        this("");
    }

    /**
     * Method that get the name of the movie.
     *
     * @return the movie name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method that set the movie name.
     *
     * @param name movie name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Method that get the actor list.
     *
     * @return the actor list.
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * Method that set actor list to the movie.
     *
     * @param actors the list of actors
     */
    public void setActors(final List<Actor> actors) {
        this.actors = actors;
    }

    /**
     * Method that get the rating of the movie.
     *
     * @return the rating.
     */
    public double getRating() {
        return rating;
    }

    /**
     * Method that set the rating of the movie.
     *
     * @param rating represents the rating of the movie.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }


}
