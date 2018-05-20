package org.minions.devfund.alejandro.movie.database;

import java.util.ArrayList;

/**
 * This class contain the actor information.
 */
public class Actor {

    private String name;
    private ArrayList<Movie> movies;

    /**
     * Constructor of the Actor class.
     * @param name the name of the actor.
     */
    public Actor(final String name) {
        this.name = name;
        this.movies = new ArrayList<Movie>();
    }

    /**
     * Constructor of the Actor class.
     */
    public Actor() {
        this.name = " ";
        this.movies = new ArrayList<Movie>();
    }


    /**
     * This method returns the name of the actor.
     * @return The name of the actor.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method will update the name of the actor.
     * @param newName The new name of the actor.
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * This method will return an ArrayList of the movies where the actor acted.
     * @return and ArrayList.
     */
    public ArrayList<Movie> getMovies() {
        return this.movies;
    }

    /**
     * This method will add a new movie where the actor acted.
     * @param newMovie A movie object to add to the list.
     */
    public void setNewMovie(final Movie newMovie) {
        this.movies.add(newMovie);
    }
}
