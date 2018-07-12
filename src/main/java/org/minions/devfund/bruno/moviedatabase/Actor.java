package org.minions.devfund.bruno.moviedatabase;

import java.util.LinkedList;
import java.util.List;

/**
 * Class represents the Actor.
 */
public class Actor {

    private String name;
    private List<Movie> movies;

    /**
     * Constructor.
     */
    public Actor() {
        movies = new LinkedList<>();
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
     * Gets a movies list.
     *
     * @return movies List.
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Sets the movie.
     *
     * @param movie Movie object.
     */
    public void setMovies(final Movie movie) {
        movies.add(movie);
    }
}
