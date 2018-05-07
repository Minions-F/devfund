package org.minions.devfund.marcos.moviedatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * It is in charged to represent a movie database with it is main attributes.
 */
public class MovieDatabase {

    private List<Movie> movieList;
    private List<Actor> actorList;

    /**
     * Initializes an instance of {@link MovieDatabase}.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * Gets the database movies list.
     *
     * @return list of {@link Movie}.
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Gets the database actors list.
     *
     * @return list of {@link Actor}.
     */
    public List<Actor> getActorList() {
        return actorList;
    }

    /**
     * Adds a movie in the database movie list.
     *
     * @param name   movie's name.
     * @param actors array of actor's names.
     */
    public void addMovie(final String name, final String[] actors) {
        if (isNewMovie(name, movieList)) {
            Movie newMovie = new Movie(name);
            List<Actor> movieActors = Arrays.stream(actors).map(Actor::new).collect(Collectors.toList());
            movieActors.forEach(actor -> actor.getMovies().add(newMovie));
            newMovie.setActors(movieActors);
            movieList.add(newMovie);
            addNewActors(movieActors);
        }
    }

    /**
     * Checks if a movie exists in a list of movies.
     *
     * @param name movie's name to check.
     * @param list list of {@link Movie}.
     * @return true if the list not contains the movie's name.
     */
    private boolean isNewMovie(final String name, final List<Movie> list) {
        return list.stream().noneMatch(movie -> movie.getName().equals(name));
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
     * Adds only new actors to the database actor's list.
     *
     * @param actors list of {@link Actor}.
     */
    private void addNewActors(final List<Actor> actors) {
        actors.stream().filter(actor -> isNewActor(actor.getName(), actorList)).forEach(actor -> actorList.add(actor));
    }

    /**
     * Adds a movie's rating.
     *
     * @param name   movie's name.
     * @param rating movie's rating value.
     */
    public void addRating(final String name, final double rating) {
        updateRating(name, rating);
    }

    /**
     * Updates the rating of a movie.
     *
     * @param name      movie's name.
     * @param newRating new movie's rating.
     */
    public void updateRating(final String name, final double newRating) {
        movieList.stream().filter(movie -> movie.getName().equals(name)).forEach(movie -> movie.setRating(newRating));
    }

    /**
     * Gets the name of the actor that has the best average rating for their movies.
     *
     * @return best actor's name.
     */
    public String getBestActor() {
        return actorList.stream().max(Comparator.comparing(Actor::movieRatingAverage)).orElse(new Actor()).getName();
    }

    /**
     * Gets the name of the movie with the highest rating.
     *
     * @return best movie's name.
     */
    public String getBestMovie() {
        return movieList.stream().max(Comparator.comparing(Movie::getRating)).orElse(new Movie()).getName();
    }
}
