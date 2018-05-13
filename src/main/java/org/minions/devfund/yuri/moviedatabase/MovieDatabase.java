package org.minions.devfund.yuri.moviedatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a  movie database with attributes and behavior.
 */
public class MovieDatabase {
    private List<Movie> movieList;
    private List<Actor> actorList;

    /**
     * Constructor Method..
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * Adds a movie to list.
     *
     * @param name   movie name.
     * @param actors actors.
     */
    public void addMovie(final String name, final String[] actors) {
        Movie movie = new Movie(name);
        if (!existentMovie(movie.getName())) {
            movieList.add(movie);
            for (String actorName : actors) {
                Actor actor = new Actor(actorName);
                movie.getActors().add(actor);
                actor.getMovies().add(movie);
                if (!existentActor(actor.getName())) {
                    actorList.add(actor);
                }
            }
        }
    }

    /**
     * Adds rating an specific movie.
     *
     * @param name   movie name.
     * @param rating movie rating.
     */
    public void addRating(final String name, final double rating) {
        Movie movie = getMovieByName(name);
        movie.setRating(movie.getRating() + rating);
    }

    /**
     * Updates the movie rating.
     *
     * @param name   movie name.
     * @param rating movie rating.
     */
    public void updateRating(final String name, final double rating) {
        Movie movie = getMovieByName(name);
        movie.setRating(rating);
    }

    /**
     * Gets the actor with best average rating.
     *
     * @return best actor.
     */
    public String getBestActor() {
        Actor bestActor = new Actor();
        for (Actor actor : actorList) {
            if (actor.getAverage() > bestActor.getAverage()) {
                bestActor = actor;
            }
        }
        return bestActor.getName();
    }

    /**
     * Gets the movie with the highest rating.
     *
     * @return best movie.
     */
    public String getBestMovie() {
        Movie bestMovie = new Movie();
        for (Movie movie : movieList) {
            if (movie.getRating() > bestMovie.getRating()) {
                bestMovie = movie;
            }
        }
        return bestMovie.getName();
    }


    /**
     * Gets movie list.
     *
     * @return movie list.
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Gets Actor list.
     *
     * @return actor list.
     */
    public List<Actor> getActorList() {
        return actorList;
    }

    /**
     * Verifies that a movie is existent.
     *
     * @param movieName movie name.
     * @return <CODE>true</CODE> if the movie is existent.
     * <CODE>false</CODE> if the movie is new.
     */
    private boolean existentMovie(final String movieName) {
        boolean flag = false;
        for (Movie movie : movieList) {
            if (movie.getName().equalsIgnoreCase(movieName)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Verifies that an actor is existent.
     *
     * @param actorName movie name.
     * @return <CODE>true</CODE> if the actor is existent.
     * <CODE>false</CODE> if the actor is new.
     */
    private boolean existentActor(final String actorName) {
        boolean flag = false;
        for (Actor actor : actorList) {
            if (actor.getName().equalsIgnoreCase(actorName)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Gets the an specific movie by name of movie list.
     *
     * @param movieName movie name.
     * @return movie searched.
     */
    private Movie getMovieByName(final String movieName) {
        Movie movieResult = new Movie();
        for (Movie movie : movieList) {
            if (movie.getName().equalsIgnoreCase(movieName)) {
                movieResult = movie;
            }
        }
        return movieResult;
    }
}
