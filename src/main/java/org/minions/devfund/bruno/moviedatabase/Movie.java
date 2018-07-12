package org.minions.devfund.bruno.moviedatabase;

import java.util.LinkedList;
import java.util.List;

/**
 * Class represents the Movie.
 */
public class Movie {

    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     * Constructor.
     */
    public Movie() {
        actors = new LinkedList<>();
    }

    /**
     * Gets the actor name.
     *
     * @return String actor name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the actor name.
     *
     * @param name String actor name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets a actors list.
     *
     * @return actors List.
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * Sets the movie.
     *
     * @param actor Actor object.
     */
    public void setActor(final Actor actor) {
        actors.add(actor);
    }

    /**
     * Sets the movie rating.
     *
     * @param ratingValue double.
     */
    public void setRating(final double ratingValue) {
        rating = ratingValue;
    }

    /**
     * Gets the movie rating.
     *
     * @return double rating.
     */
    public double getRating() {
        return rating;
    }
}
