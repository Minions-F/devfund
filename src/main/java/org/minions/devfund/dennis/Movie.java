package org.minions.devfund.dennis;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the methods for Movie class.
 */
public class Movie implements Comparable<Movie> {
    private String name;
    private List<Actor> actors;
    private double rating;

    /**
     * Constructor for Movie.
     * @param name of Movie
     */
    public Movie(final String name) {
        this.name = name;
        this.rating = 0.0;
        actors = new ArrayList<>();
    }

    /**
     * Default values for Constructor.
     */
    public Movie() {
        this("");
    }

    /**
     * Get name of Movie.
     * @return name of movie
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the movie.
     * @param name of movie
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get rating of movie.
     * @return rating of movie
     */
    public double getRating() {
        return rating;
    }

    /**
     * Set the rating of movie.
     * @param rating of the movie
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }

    /**
     * Get the all Actors for the movie.
     * @return the actors
     */
    public List<Actor> getActors() {
        return actors;
    }

    /**
     * Set the actors for the movies.
     * @param actors in the array
     */
    public void setActors(final List<Actor> actors) {
        this.actors = actors;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param object the reference object with which to compare.
     * @return @code true} if this object is the same as the obj argument; {@code false} otherwise.
     */
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Movie newMovie = (Movie) object;
        return newMovie.getName().equals(name);
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link java.util.HashMap}.
     * @return a hash code value for this object.
     */
    public int hashCode() {
        return 0;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * @param o the object to be compared.
     * @return  a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(final Movie o) {
        return Double.compare(rating, o.getRating());
    }
}
