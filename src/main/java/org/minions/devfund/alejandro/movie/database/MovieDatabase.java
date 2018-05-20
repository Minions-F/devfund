package org.minions.devfund.alejandro.movie.database;

import java.util.ArrayList;

/**
 * This method contains all the information about movie data base class.
 */
public class MovieDatabase {

    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * This method is the constructor for movieDatabase class.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * This method takes in the name of a movie that is not currently in the database along with a list of actors
     * for that movie. If the movie is already in the database, your code ignores this request
     * (this specification is an oversimplification).
     * If the movie is a new movie, a movie object is created and added to the movieList.
     * If any of the actors happen to be new, they will be added to the actorList.
     * @param name the name of the movie.
     * @param actors a list of actors that act in the movie.
     */
    void addMovie(final String name, final String[] actors) {

        if (!getMovieOnList(name)) {
            Movie movie = new Movie(name);
            movieList.add(movie);
            for (String actor : actors) {
                updateActorList(actor, movie);
            }
        }
    }

    /**
     * This method will update the actor list and create a new one if the actor is new.
     * @param actorsName String that represent the name of the actor.
     * @param movie An object that is the movie where the actor acted.
     */
    private void updateActorList(final String actorsName, final Movie movie) {
        boolean actorExists = false;
        for (Actor actorInList : actorList) {
            if (actorInList.getName().equals(actorsName)) {
                actorExists = true;
                actorInList.setNewMovie(movie);
            }
        }

        if (!actorExists) {
            Actor newActor = new Actor(actorsName);
            this.actorList.add(newActor);
            newActor.setNewMovie(movie);
        }
    }

    /**
     * Add a rating for this movie. Assume that the name argument
     * will definitely be a name that is currently in the database.
     * @param name The name of a movie that is currently on tha DB.
     * @param rating The rating that will movie will be assign.
     */
    void addRating(final String name, final double rating) {

        updateRating(name, rating);
    }

    /**
     * Overwrite the current rating of a movie with this new rating.
     * Again, assume that the name argument will definitely be a name that is currently in the database.
     * @param name The name of a movie that is currently on tha DB.
     * @param newRating The rating that will movie will be assign.
     */
    void updateRating(final String name, final double newRating) {

        for (Movie movie : this.movieList) {
            if (movie.getName().equals(name)) {
                movie.setRating(newRating);
            }
        }
    }

    /**
     * Returns the name of the actor that has the best average rating for their movies.
     * @return the actor with the best rating.
     */
    String getBestActor() {

        String actorName = " ";
        double actorRating = 0;
        double rating = 0;
        int movieCount = 0;
        for (Actor actor : this.actorList) {
            for (Movie movie : actor.getMovies()) {
                movieCount++;
                rating = rating + movie.getRating();
            }
            rating = rating / movieCount;
            if (rating > actorRating) {
                actorRating = rating;
                actorName = actor.getName();
            }
        }
        return actorName;
    }

    /**
     * Returns the name of the movie with the highest rating.
     * @return Return the name of the movie.
     */
    String getBestMovie() {

        String movieName = " ";
        double rating;
        double highestRating = 0;

        for (Movie movie : this.movieList) {
            rating = movie.getRating();
            if (rating > highestRating) {
                highestRating = rating;
                movieName = movie.getName();
            }
        }
        return movieName;
    }

    /**
     * This method return if a movie is on the movie list.
     * @param movieName the name of the movie.
     * @return true or false depending if the movie was found.
     */
    boolean getMovieOnList(final String movieName) {
        boolean movieExists = false;
        for (Movie movie : this.movieList) {
            if (movie.getName().equals(movieName)) {
                movieExists = true;
            }
        }
        return movieExists;
    }

    /**
     * Return the movie list as an array.
     * @return an array of movies.
     */
    ArrayList<Movie> getMovieList() {
        return this.movieList;
    }

    /**
     * Return the actor list as an array.
     * @return an array of actors.
     */
    ArrayList<Actor> getActorList() {
        return this.actorList;
    }
}
