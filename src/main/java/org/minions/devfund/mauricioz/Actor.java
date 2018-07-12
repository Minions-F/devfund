package org.minions.devfund.mauricioz;

import java.util.ArrayList;
import java.util.List;

/**
 * Actor Class.
 */
public class Actor {
    private String name;
    private List<Movie> movies;

    /**
     * Constructor.
     */
    public Actor() {
        this.name = "";
        this.movies = new ArrayList<>();
    }

    /**
     * get actorn name.
     * @return actor name
     */
    public String getName() {
        return name;
    }

    /**
     * set actor name.
     * @param name actor name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * get movies where actor worked.
     * @return list of movies.
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * set movies list.
     * @param movies list of movies
     */
    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * method to get the average rating for movies of a given actor.
     * @return average rating.
     */
    public double ratingAverage() {
        double ratingAvg = 0;
        for (Movie mov : this.movies) {
            ratingAvg += mov.getRating();
        }
        return ratingAvg / this.movies.size();
    }
}
