package org.minions.devfund.dennis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is the methods for MovieDatabase class.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

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
        Movie newMovie = new Movie(name);
        if (!movieList.contains(newMovie)) {
            movieList.add(newMovie);
            for (String actorName : actors) {
                Actor actor = new Actor(actorName);
                if (!actorList.contains(actor)) {
                    actorList.add(actor);
                } else {
                    actor = actorList.get(actorList.indexOf(actor));
                }
                newMovie.getActors().add(actor);
                actor.getMovies().add(newMovie);
            }
        }
    }

    /**
     * Add a rating for this movie.
     * Assume that the name argument will definitely be a name that is currently in the database.
     * @param name of the movie
     * @param rating of the movie
     */
    public void addRating(final String name, final double rating) {
        if (movieList.indexOf(new Movie(name)) != -1) {
            movieList.get(movieList.indexOf(new Movie(name))).setRating(rating);
        }
    }

    /**
     * Overwrite the current rating of a movie with this new rating.
     * Assume that the name argument will definitely be a name that is currently in the database.
     * @param name of the movie
     * @param newRating of the movie
     */
    public void updateRating(final String name, final double newRating) {
        movieList.get(movieList.indexOf(new Movie(name))).setRating(newRating);
    }

    /**
     * Returns the name of the movie with the highest rating.
     * In the case of a tie, return any one of the best actors.
     * @return best actor
     */
    public String getBestActor() {
        Collections.sort(actorList);
        return actorList.get(actorList.size() - 1).getName();
    }

    /**
     * Returns the name of the actor that has the best average rating for their movies.
     * In the case of a tie, return any one of the best movies.
     * @return best movie
     */
    public String getBestMovie() {
        Collections.sort(movieList);
        return movieList.get(movieList.size() - 1).getName();
    }
}
