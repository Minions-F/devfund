package org.minions.devfund.mauricioz;

import java.util.ArrayList;
import java.util.List;

/**
 * move data base class definition.
 */
public class MovieDatabase {
    private List<Movie> movies;
    private List<Actor> actors;

    /**
     * constructor.
     */
    public MovieDatabase() {
        this.movies = new ArrayList<>();
        this.actors = new ArrayList<>();
    }

    /**
     * add a new movie in the db.
     * @param name movie name.
     * @param actors casting list.
     */
    public void addMovie(final String name, final String[] actors) {
        if (!isAlreadyRegistered(name)) {
            Movie newMovie = new Movie(name);
            movies.add(newMovie);
            Actor actor;
            List<Actor> casting = new ArrayList<>();
            for (String actorName : actors) {
                actor = new Actor();
                actor.setName(actorName);
                casting.add(actor);
                if (!actorIntheDB(actorName)) {
                    this.actors.add(actor);
                }
            }
            newMovie.setActors(casting);
        }
    }

    /**
     * verify actor already exist.
     * @param actorName name.
     * @return true or false.
     */
    private boolean actorIntheDB(final String actorName) {
        for (Actor actor : actors) {
            if (actor.getName().equals(actorName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * verify if movie already exists into the DB.
     * @param name movie name
     * @return true or false
     */
    private boolean isAlreadyRegistered(final String name) {
        for (Movie mov : movies) {
            if (mov.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Rate a movie.
     * @param name movie name.
     * @param rating rating that will be assigned to the movie.
     */
    public void addRating(final String name, final double rating) {
        for (Movie mov : movies) {
            if (mov.getName().equals(name)) {
                mov.setRating(rating);
            }
        }
    }

    /**
     * update Rate of a movie.
     * @param name movie name.
     * @param rating rating that will be assigned to the movie.
     */
    public void updateRating(final String name, final double rating) {
        addRating(name, rating);
    }

    /**
     * get best actor.
     * @return best actor name.
     */
    public String getBestActor() {
        String bestActorName = "";
        double averageMovieRating = -1.0;
        for (Actor actor : this.actors) {
            if (actor.ratingAverage() > averageMovieRating) {
                averageMovieRating = actor.ratingAverage();
                bestActorName = actor.getName();
            }
        }
        return bestActorName;
    }

    /**
     * get the best movie rated.
     * @return movie name
     */
    public String getBestMovie() {
        String movieName = this.movies.get(0).getName();
        double rating = this.movies.get(0).getRating();
        for (Movie mov : movies) {
            if (mov.getRating() > rating) {
                rating = mov.getRating();
                movieName = mov.getName();
            }
        }
        return movieName;
    }

    /**
     * list of movies in the DB.
     * @return list of movies
     */
    public List<Movie> getMovieList() {
        return movies;
    }

    /**
     * get actors list.
     * @return list of actors.
     */
    public List<Actor> getActorList() {
        return actors;
    }
}
