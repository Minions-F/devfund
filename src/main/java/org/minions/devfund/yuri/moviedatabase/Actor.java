package org.minions.devfund.yuri.moviedatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Actor with all attributes and behavior.
 */
public class Actor {
    private String name;
    private List<Movie> movies;

    /**
     * Constructor method.
     *
     * @param name actor name.
     */
    public Actor(final String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    /**
     * Constructor method by default.
     */
    public Actor() {
        this("");
    }

    /**
     * Sets the name of the actor.
     *
     * @param name new actor name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Sets the movies related with the actor.
     *
     * @param movies list of movies.
     */
    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Gets the actor name.
     *
     * @return actor name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the actor movie list.
     *
     * @return the movie list.
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Gets the actor average.
     *
     * @return actor average.
     */
    public double getAverage() {
        double result = 0;
        for (Movie movie : movies) {
            result = result + movie.getRating();
        }
        return movies.isEmpty() ? 0 : result / movies.size();
    }
}
