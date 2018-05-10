package org.minions.devfund.dennis;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the methods for Actor class.
 */
public class Actor implements Comparable<Actor> {
    private String name;
    private List<Movie> movies;

    /**
     * Constructor for Actor.
     * @param name of actor
     */
    public Actor(final String name) {
        this.name = name;
        movies = new ArrayList<>();
    }

    /**
     * Default values for Constructor.
     */
    public Actor() {
        this("");
    }

    /**
     * Get name of actor.
     * @return get the name
     */
    public String getName() {
        return name;
    }

    /**
     * set the name in the list.
     * @param name of actor
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * get all movies of actor.
     * @return arrayList of the movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Set the movies in the array list.
     * @param movies capture the name of movie
     */
    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
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
        Actor newActor = (Actor) object;
        return newActor.getName().equals(name);
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
     * Generate the actor rating.
     * @return get the actor rating
     */
    public double getActorRating() {
        double ratingSum = 0;
        for (Movie movie : movies) {
            ratingSum += movie.getRating();
        }
        return ratingSum / movies.size();
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
    public int compareTo(final Actor o) {
        Double rating = getActorRating();
        return Double.compare(rating, o.getActorRating());
    }
}
