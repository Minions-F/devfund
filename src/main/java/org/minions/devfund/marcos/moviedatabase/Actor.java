package org.minions.devfund.marcos.moviedatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * It is in charge to represent an actor and it is properties.
 */
public class Actor {

    private String name;
    private List<Movie> movies;

    /**
     * Initializes an instance of {@link Actor}.
     *
     * @param name actor name value.
     */
    public Actor(final String name) {
        this.name = name;
        movies = new ArrayList<>();
    }

    /**
     * Initializes an instance of {@link Actor}.
     */
    public Actor() {
        this("");
    }

    /**
     * Gets the actor's name attribute value.
     *
     * @return name value.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the actor's name attribute value.
     *
     * @param name new actor's name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the actor's movies list attribute value.
     *
     * @return movies list.
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Sets the actor's movies list attribute value.
     *
     * @param movies actor's movies list.
     */
    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Calculates the movie rating average of the actor's list.
     *
     * @return movie rating average value.
     */
    public double movieRatingAverage() {
        return movies.stream().mapToDouble(Movie::getRating).average().orElse(0);
    }
}
