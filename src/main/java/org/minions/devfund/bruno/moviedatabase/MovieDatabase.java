package org.minions.devfund.bruno.moviedatabase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class manages the data base movie.
 */
public class MovieDatabase {
    private static final String DATABASE_MOVIES_PATH = "src/main/resources/bruno/movies.txt";
    private static final String DATABASE_RATING_PATH = "src/main/resources/bruno/rating.txt";
    private List<Actor> actorList;
    private List<Movie> movieList;

    /**
     * Constructor.
     */
    public MovieDatabase() {
        actorList = new LinkedList<>();
        movieList = new LinkedList<>();
    }

    /**
     * Adds movie to the data base.
     *
     * @param movieName String.
     * @param actors    Array.
     */
    public void addMovie(final String movieName, final String[] actors) {
        List<String> actorsArray = Arrays.asList(actors);
        actorsArray.forEach(actorName -> addActor(actorName, movieName));
    }

    /**
     * Adds the actor according if the actor name was added before.
     *
     * @param actorName String to set in Movie object.
     * @param movieName String.
     */
    private void addActor(final String actorName, final String movieName) {
        Actor actor = getAnActor(actorName);
        if (actor != null) {
            generatesTheMovies(actor, movieName);
        } else {
            Actor newActor = new Actor();
            newActor.setName(actorName);
            generatesTheMovies(newActor, movieName);
            actorList.add(newActor);
        }
    }

    /**
     * Adds Rating to a movie.
     *
     * @param name   String movie.
     * @param rating Double rating.
     */
    public void addRating(final String name, final double rating) {
        Movie movie = getAMovie(name);
        if (movie != null) {
            movie.setRating(rating);
        }
    }

    /**
     * Updates the movie rating.
     *
     * @param name      String movie.
     * @param newRating Double new Rating.
     */
    public void updateRating(final String name, final double newRating) {
        Objects.requireNonNull(movieList.stream().filter(movie -> movie.getName().equals(name)).findFirst()
                .orElse(null)).setRating(newRating);
    }

    /**
     * Calculates the average from the List movies.
     *
     * @param movies List.
     * @return average rating.
     */
    private double calculateTheAverageMovies(final List<Movie> movies) {
        return movies.stream().mapToDouble(Movie::getRating).sum() / movies.size();
    }

    /**
     * Gets the best Actor.
     *
     * @return String name actor.
     */
    public String getBestActor() {
        String bestActor = "";
        double bestAverage = 0;
        for (Actor actor : actorList) {
            if (calculateTheAverageMovies(actor.getMovies()) > bestAverage) {
                bestAverage = calculateTheAverageMovies(actor.getMovies());
                bestActor = actor.getName();
            }
        }
        return bestActor;
    }

    /**
     * Gets the best movie.
     *
     * @return String movie name.
     */
    public String getBestMovie() {
        String bestMovie = "";
        double majorRating = 0;
        for (Movie movie : movieList) {
            if (movie.getRating() > majorRating) {
                majorRating = movie.getRating();
                bestMovie = movie.getName();
            }
        }
        return bestMovie;
    }

    /**
     * Gets the actor list.
     *
     * @return actor List.
     */
    public List<Actor> getActorList() {
        return actorList;
    }

    /**
     * Gets the movie list.
     *
     * @return movie List.
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Manages the Actors and Movies generates according the movies and rating data base file.
     */
    public void main() {
        List<String> linesMovies = readDataBase(DATABASE_MOVIES_PATH);
        List<String> linesRating = readDataBase(DATABASE_RATING_PATH);
        linesMovies.forEach(line -> generateActors(line.split(", ")));
        linesRating.remove(0);
        linesRating.forEach(line -> addsTheRatingObtainedFromDB(line.split("\t")));
    }

    /**
     * Reads a txt data base file according the path file.
     *
     * @param path data base File.
     * @return a List with the lines obtained from the data base file.
     */
    public List<String> readDataBase(final String path) {
        List<String> lines = new LinkedList<>();
        Path paths = Paths.get(path);
        try (Stream<String> stream = Files.lines(paths)) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        return lines;
    }

    /**
     * Generates Actors according the line obtained from data base file.
     *
     * @param line String array form data base file.
     */
    public void generateActors(final String[] line) {
        String[] moviesArray = Arrays.copyOfRange(line, 1, line.length);
        Actor actor = new Actor();
        String actorName = line[0];
        actor.setName(actorName);
        List<String> movies = Arrays.asList(moviesArray);
        movies.forEach(movieName -> generatesTheMovies(actor, movieName));
        actorList.add(actor);
    }

    /**
     * Generates the movies according if the movie name was generated before.
     *
     * @param actor     Actor object to set in Movie object
     * @param movieName String to verify if the movie was generated before
     */
    public void generatesTheMovies(final Actor actor, final String movieName) {
        Movie movie = getAMovie(movieName);
        if (movie != null) {
            movie.setActor(actor);
            actor.setMovies(movie);
        } else {
            Movie newMovie = new Movie();
            newMovie.setName(movieName);
            newMovie.setActor(actor);
            actor.setMovies(newMovie);
            movieList.add(newMovie);
        }
    }

    /**
     * Gets a movie according a movie name.
     *
     * @param movieName String value.
     * @return Movie object.
     */
    public Movie getAMovie(final String movieName) {
        return movieList.stream().filter(movie -> movie.getName().equals(movieName)).findFirst().orElse(null);
    }

    /**
     * Gets a actor according a actor name.
     *
     * @param actorName String value.
     * @return Actor object.
     */
    public Actor getAnActor(final String actorName) {
        return actorList.stream().filter(movie -> movie.getName().equals(actorName)).findFirst().orElse(null);
    }

    /**
     * Adds the rating obtained from the file line of the database.
     *
     * @param lineFromDB String array.
     */
    public void addsTheRatingObtainedFromDB(final String[] lineFromDB) {
        String rating = lineFromDB[1];
        String movieName = lineFromDB[0];
        addRating(movieName, Double.parseDouble(rating));
    }
}
