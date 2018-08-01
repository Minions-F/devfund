package org.minions.devfund.lourdes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Class that manage the movie information.
 */
public class MovieDatabase {
    private List<Movie> movieList;
    private List<Actor> actorList;

    /**
     * Constructor.
     */
    public MovieDatabase() {
        this.movieList = new ArrayList<>();
        this.actorList = new ArrayList<>();
    }

    /**
     * Method to add a new movie to the movie list.
     *
     * @param name   represents the movie name.
     * @param actors actor list from a movie.
     */
    public void addMovie(final String name, final String[] actors) {
        Movie movie = createMovie(name);
        List<Actor> movieActors = new ArrayList<>();
        for (String actorName : actors) {
            Actor actor = createActor(actorName);
            actor.addMovie(movie);
            movieActors.add(actor);
        }
        movie.setActors(movieActors);
    }

    /**
     * Method that create a new new movie object.
     *
     * @param movieName represents the movie name.
     * @return return the created movie.
     */
    public Movie createMovie(final String movieName) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(movieName)) {
                return movie;
            }
        }
        Movie movie = new Movie(movieName);
        movieList.add(movie);
        return movie;
    }

    /**
     * Method that create a new Actor object.
     *
     * @param actorName represents the actor name to be created.
     * @return the created actor.
     */
    public Actor createActor(final String actorName) {
        for (Actor actor : actorList) {
            if (actor.getName().equals(actorName)) {
                return actor;
            }
        }
        Actor newActor = new Actor(actorName);
        actorList.add(newActor);
        return newActor;
    }

    /**
     * Method that update the rating of the given movie name.
     *
     * @param name      represents the movie name.
     * @param newRating the new rating to be set.
     */
    public void updateRating(final String name, double newRating) {
        Optional<Movie> movieRating = movieList.stream()
                .filter(movie -> movie.getName().equals(name))
                .findFirst();
        movieRating.ifPresent(movie -> movie.setRating(newRating));
    }

    /**
     * Method that return the best Actor.
     *
     * @return the best actor.
     */
    public String getBestActor() {
        return actorList.stream()
                .max(Comparator.comparingDouble(Actor::averageRating))
                .orElse(new Actor())
                .getName();

    }

    /**
     * Method that return the best movie fo the list.
     *
     * @return the best movie.
     */
    public String getBestMovie() {
        return movieList.stream()
                .max(Comparator.comparingDouble(Movie::getRating))
                .orElse(new Movie())
                .getName();
    }

    /**
     * Method that return the movie list.
     *
     * @return the movie list.
     */

    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Method that get the actor List.
     *
     * @return return the actor List.
     */
    public List<Actor> getActorList() {
        return actorList;
    }
}
