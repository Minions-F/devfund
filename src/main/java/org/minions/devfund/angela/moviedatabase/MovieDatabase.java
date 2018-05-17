package org.minions.devfund.angela.moviedatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages the movie database object.
 */
public class MovieDatabase {

    private List<Movie> movieList;
    private List<Actor> actorList;

    /**
     * Constructor that initializes a list
     * of movies and a list of actors.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * Gets the movies list.
     *
     * @return {@link List}.
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Gets the actors list.
     *
     * @return {@link List}.
     */
    public List<Actor> getActorList() {
        return actorList;
    }

    /**
     * Adds a new movie if not exists.
     *
     * @param name   String the movie name.
     * @param actors array of string with the actors names.
     */
    void addMovie(final String name, final String[] actors) {
        if (movieList.stream().noneMatch(movie -> movie.getName().equalsIgnoreCase(name))) {
            final Movie newMovie = new Movie(name);
            newMovie.setActors(Arrays.stream(actors).map(Actor::new).collect(Collectors.toList()));
            Arrays.stream(actors)
                    .filter(actor -> actorList.stream()
                            .noneMatch(actorInDatabase -> actorInDatabase.getName().equalsIgnoreCase(actor)))
                    .forEach(newActor -> {
                        final Actor newActorObject = new Actor(newActor);
                        newActorObject.getMovies().add(newMovie);
                        actorList.add(newActorObject);
                    });

            movieList.add(newMovie);
        }
    }

    /**
     * Adds rating to a movie.
     *
     * @param name   the movie name where to add the rating..
     * @param rating double the rating to add to movie.
     */
    void addRating(final String name, final double rating) {
        updateRating(name, getMovieByName(name).getRating() + rating);
    }

    /**
     * Updates a movie rating.
     *
     * @param name      String the movie name.
     * @param newRating double new rating.
     */
    void updateRating(final String name, final double newRating) {
        getMovieByName(name).setRating(newRating);
    }

    /**
     * Gets the best actor base on the average rating.
     *
     * @return String the name of the best actor.
     */
    String getBestActor() {
        return actorList.stream()
                .max(Comparator.comparing(Actor::getRating))
                .orElse(new Actor("")).getName();
    }


    /**
     * Gets the name of the movie with the best rating.
     *
     * @return String with the name of the best movie.
     */
    String getBestMovie() {
        return movieList.stream()
                .max(Comparator.comparing(Movie::getRating))
                .orElse(new Movie("")).getName();

    }

    /**
     * Gets a movie by its name.
     *
     * @param name string movie name.
     * @return {@link Movie}.
     */
    private Movie getMovieByName(final String name) {
        return movieList.stream()
                .filter(movie -> movie.getName().equalsIgnoreCase(name)).findAny().orElse(new Movie(""));
    }
}
