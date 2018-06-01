package org.minions.devfund.lourdes;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that define the Actor entity.
 */
public class Actor {
    private String name;
    private List<Movie> movies;

    /**
     * Constructor that recieves the actor name.
     *
     * @param name represents the actor name.
     */
    public Actor(final String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    /**
     * Constructor.
     */
    public Actor() {
        this("");
    }

    /**
     * Method that add a movie to the actor list.
     *
     * @param movie represents the object Movie.
     */
    public void addMovie(final Movie movie) {
        movies.add(movie);
    }

    /**
     * Method that get the average rating of the actor.
     *
     * @return the average rating.
     */
    public double averageRating() {
        return movies.stream()
                .mapToDouble(Movie::getRating)
                .average()
                .orElse(0.0);
    }

    /**
     * Method that get the actor name.
     *
     * @return the name of Actor.
     */
    public String getName() {
        return name;
    }

    /**
     * Method that set the actor Name.
     *
     * @param name represents the actor name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Method that set the movies of the actor.
     *
     * @param movies movie list.
     */
    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Method that get the movies of the actor.
     *
     * @return movie list.
     */
    public List<Movie> getMovies() {
        return movies;
    }
}
