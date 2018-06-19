package org.minions.devfund.dennis.moviedatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the methods for MovieDatabase class.
 */
public class MovieDatabase {
    private List<Movie> movieList;
    private List<Actor> actorList;

    /**
     * Constructor for MovieDatabase.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * Get the actor list.
     * @return actor list
     */
    public List<Actor> getActorList() {
        return this.actorList;
    }

    /**
     * Get the movie list.
     * @return movie list
     */
    public List<Movie> getMovieList() {
        return this.movieList;
    }

    /**
     * This method takes in the name of a movie that is not currently in the database along with a list
     * of actors for that movie.
     * If the movie is already in the database, your code ignores this request
     * (this specification is an oversimplification).
     * If the movie is a new movie, a movie object is created and added to the movieList.
     * If any of the actors happen to be new, they will be added to the actorList.
     * @param name save name
     * @param actors save actors
     */
    public void addMovie(final String name, final String[] actors) {
        if (movieList.stream().noneMatch(movie -> movie.getName().equals(name))) {
            Movie newMovie = new Movie(name);
            List<Actor> movieActors = Arrays.stream(actors).map(Actor::new).collect(Collectors.toList());
            movieActors.forEach(actor -> actor.getMovies().add(newMovie));
            newMovie.setActors(movieActors);
            movieList.add(newMovie);
            movieActors.stream()
                    .filter(actor -> isNewActor(actor.getName(), actorList))
                    .forEach(actor -> actorList.add(actor));
        }
    }

    /**
     * Checks if an actor exists in a list of actors.
     *
     * @param name actor's name to check.
     * @param list list of {@link Actor}.
     * @return true if the list not contains the actor's name.
     */
    private boolean isNewActor(final String name, final List<Actor> list) {
        return list.stream().noneMatch(actor -> actor.getName().equals(name));
    }

    /**
     * Add a rating for this movie.
     * Assume that the name argument will definitely be a name that is currently in the database.
     * @param name of the movie
     * @param rating of the movie
     */
    public void addRating(final String name, final double rating) {
        updateRating(name, rating);
    }

    /**
     * Overwrite the current rating of a movie with this new rating.
     * Assume that the name argument will definitely be a name that is currently in the database.
     * @param name of the movie
     * @param newRating of the movie
     */
    public void updateRating(final String name, final double newRating) {
        movieList.stream()
                .filter(movie -> movie.getName().equals(name))
                .forEach(movie -> movie.setRating(newRating));
    }

    /**
     * Returns the name of the movie with the highest rating.
     * In the case of a tie, return any one of the best actors.
     * @return best actor
     */
    public String getBestActor() {
        return actorList.stream()
                .max(Comparator.comparing(Actor::getActorRating))
                .orElse(new Actor()).getName();
    }

    /**
     * Returns the name of the actor that has the best average rating for their movies.
     * In the case of a tie, return any one of the best movies.
     * @return best movie
     */
    public String getBestMovie() {
        return movieList.stream()
                .max(Comparator.comparing(Movie::getRating))
                .orElse(new Movie()).getName();
    }
}
