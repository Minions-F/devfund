package org.minions.devfund.chelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MovieDatabase class.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * MovieDatabase constructor.
     */
    MovieDatabase() {
        movieList = new ArrayList<>();
        actorList =  new ArrayList<>();
    }

    /**
     * Getter for MovieList.
     * @return movie list
     */
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Getter for ActorList.
     * @return actor list
     */
    public ArrayList<Actor> getActorList() {
        return actorList;
    }

    /**
     * This method takes in the name of a movie that is not currently in the database.
     * Along with a list of actors for that movie.
     * @param name movie name
     * @param actors actors list
     */
    void addMovie(final String name, final String[] actors) {
        if (!getMovieList().contains(new Movie(name))) {
            Movie newMovie = new Movie(name);
            newMovie.setName(name);

            ArrayList<Actor> actorsMovieList = new ArrayList<>();
            for (String actor : actors) {
                actorsMovieList.add(new Actor(actor));
            }
            newMovie.setActors(actorsMovieList);
            getMovieList().add(newMovie);
        } else {
            Movie existingMovie = getMovieList().get(getMovieList().indexOf(new Movie(name)));
            ArrayList<Actor> existingActors = existingMovie.getActors();

            for (String actor : actors) {
                if (!existingMovie.getActors().contains(new Actor(actor))) {
                    existingActors.add(new Actor(actor));
                }
            }
            existingMovie.setActors(existingActors);
        }

        for (String actor : actors) {
            if (!getActorList().contains(new Actor(actor))) {
                Actor newActor = new Actor(actor);
                ArrayList<Movie> actorMoviesList = new ArrayList<>();
                actorMoviesList.add(new Movie(name));
                newActor.setMovies(actorMoviesList);
                getActorList().add(newActor);
            } else {
                Actor existingActor = getActorList().get(getActorList().indexOf(new Actor(actor)));
                ArrayList<Movie> existingMovies = existingActor.getMovies();

                if (!existingActor.getMovies().contains(new Movie(name))) {
                    existingMovies.add(new Movie(name));
                }
                existingActor.setMovies(existingMovies);

            }
        }
    }

    /**
     * Add a rating for this movie.
     * @param name of the movie
     * @param rating of the movie
     */
    void addRating(final String name, final double rating) {
        for (Movie movie: getMovieList()) {
            if (movie.getName().contains(name)) {
                movie.setRating(rating);
                break;
            }
        }
    }

    /**
     * Updates the current rating of a movie with this new rating.
     * @param name of the movie.
     * @param newRating of the movie.
     */
    void updateRating(final String name, final double newRating) {
        movieList.get(movieList.indexOf(new Movie(name))).setRating(newRating);
    }

    /**
     * Returns the name of the actor that has the best average rating for their movies.
     * @return the name of the best actor.
     */
    String getBestActor() {
        double maxActorRating = 0;
        String maxActorName = null;
        for (Actor actor : getActorList()) {
            if (actor.getActorRating(getMovieList()) >= maxActorRating) {
                maxActorRating = actor.getActorRating(getMovieList());
                maxActorName = actor.getName();
            }
        }
        return maxActorName;
    }

    /**
     * Returns the name of the movie with the highest rating.
     * @return best movie.
     */
    String getBestMovie() {
        double maxRatingMovie = 0;
        String maxRatingMovieName = null;
        for (Movie movie : getMovieList()) {
            if (movie.getRating() >= maxRatingMovie) {
                maxRatingMovie = movie.getRating();
                maxRatingMovieName = movie.getName();
            }
        }
        return maxRatingMovieName;
    }

    /**
     * Main method.
     * @param args args
     */
    public static void main(final String[] args) {
        MovieDatabase movieDatabase = new MovieDatabase();
        File fileName = new File("./resources/movies.txt");
        try {
            Scanner read = new Scanner(fileName, "UTF-8");

            while (read.hasNextLine()) {
                String[] actorMovies = read.nextLine().split(",", -1);
                for (int i = 1; i < actorMovies.length; i++) {
                    movieDatabase.addMovie(actorMovies[i], new String[]{actorMovies[0] });
                }
            }
            read.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        }

        File ratingsFile = new File("./resources/ratings.txt");

        try {
            Scanner read = new Scanner(ratingsFile, "UTF-8");

            read.nextLine();
                while (read.hasNextLine()) {
                    String[] movieRating = read.nextLine().split("\t", -1);
                    for (int i = 1; i < movieRating.length; i++) {
                        movieDatabase.addRating(movieRating[0], Double.parseDouble(movieRating[1]));
                    }
                }

            read.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + ratingsFile + "'");
        }
        System.out.println(movieDatabase.getBestActor());
        System.out.println(movieDatabase.getBestMovie());
    }
}
