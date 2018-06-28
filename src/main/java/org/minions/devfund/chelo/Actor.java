package org.minions.devfund.chelo;

import java.util.ArrayList;

/**
 * Actor class.
 */
public class Actor {
    private String name;
    private ArrayList<Movie> movies;

    /**
     * Actor constructor.
     * @param name actor
     */
    public Actor(final String name) {
        this.name = name;
        movies = new ArrayList<>();
    }

    /**
     * Actor constructor.
     */
    public Actor() {
        this("");
    }

    /**
     * A method to get Actor's name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * A method to set Actor's name.
     * @param name set name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * A method to get Actor's movies.
     * @return movies list.
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * A method to set Actor's movies.
     * @param movies actor's movies
     */
    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }

    /**
     * A method to get Actor movies ranking.
     * @param movies actor's movies.
     * @return ranking.
     */
    public double getActorRating(final ArrayList<Movie> movies) {
        double ratingMovies = 0;
        for (Movie movie : movies) {
            ratingMovies += movie.getRating();
        }
        return ratingMovies / movies.size();
    }
}
