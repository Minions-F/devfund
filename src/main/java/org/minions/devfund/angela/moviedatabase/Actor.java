package org.minions.devfund.angela.moviedatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the Actor object.
 */
public class Actor {

    private String name;
    private List<Movie> movies;

    /**
     * Constructor of {@link Actor}.
     *
     * @param newName string actor name.
     */
    public Actor(final String newName) {
        name = newName;
        movies = new ArrayList<>();
    }

    /**
     * Gets the name of the actor.
     *
     * @return String the actor name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the actor.
     *
     * @param newName String new actor's name.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Gets the movies where the actor participate.
     *
     * @return a list with the movies.
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Sets the movies list where the actor participate.
     *
     * @param movies list with the new movies.
     */
    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Gets the actor rating based on their movies.
     *
     * @return double the rating average points.
     */
    public double getRating() {
        return getMovies().stream()
                .mapToDouble(Movie::getRating).sum() / getMovies().size();

    }
}
