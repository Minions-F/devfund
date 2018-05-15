package org.minions.devfund.dennis;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Unit Test class for MovieDatabase with all methods.
 */
public class MovieDatabaseTest {
    private MovieDatabase movieDatabase;

    /**
     * Start movie data base for each test.
     */
    @Before
    public void init() {
        movieDatabase = new MovieDatabase();
    }

    /**
     * Movie Database has empty actors and movies lists.
     */
    @Test
    public void testMovieDatabaseHasEmptyActorsAndMovies() {
        assertTrue(movieDatabase.getMovieList().isEmpty());
        assertTrue(movieDatabase.getActorList().isEmpty());
    }

    /**
     * Add new movie to database.
     */
    @Test
    public void testAddMovieToDatabaseWithActors() {
        final String movieName = "The Expendables";
        final String[] actors = new String[]{"Sylvester Stallone", "Jason Statham"};
        final int movieList = 1;
        final int actorList = 2;
        movieDatabase.addMovie(movieName, actors);
        assertEquals(movieList, movieDatabase.getMovieList().size());
        assertEquals(actorList, movieDatabase.getActorList().size());
    }

    /**
     * Add duplicated movies to database.
     */
    @Test
    public void testDuplicatedMovieToDatabaseWithActors() {
        final String movieName = "The Expendables";
        final String[] actors = new String[]{"Sylvester Stallone", "Jason Statham"};
        final int movieList = 1;
        final int actorList = 2;
        movieDatabase.addMovie(movieName, actors);
        movieDatabase.addMovie(movieName, actors);
        assertEquals(movieList, movieDatabase.getMovieList().size());
        assertEquals(actorList, movieDatabase.getActorList().size());
    }

    /**
     * Add duplicated actors to database.
     */
    @Test
    public void testDuplicatedActorsToDatabaseWithMovie() {
        final String movieNameOne = "The Expendables";
        final String[] actorsOne = new String[]{"Sylvester Stallone", "Jason Statham"};
        final String movieNameTwo = "The Expendables II";
        final String[] actorsTwo = new String[]{"Sylvester Stallone", "Jason Statham"};
        final int movieList = 2;
        final int actorList = 2;
        movieDatabase.addMovie(movieNameOne, actorsOne);
        movieDatabase.addMovie(movieNameTwo, actorsTwo);
        assertEquals(movieList, movieDatabase.getMovieList().size());
        assertEquals(actorList, movieDatabase.getActorList().size());
    }

    /**
     * Add new movie rating to movie in database.
     */
    @Test
    public void testAddRatingToMovieInDatabase() {
        final int firstMovie = 0;
        final double delta = 0;
        final String movieName = "The Expendables";
        final String[] actors = new String[]{"Sylvester Stallone", "Jason Statham"};
        final int rating = 10;
        movieDatabase.addMovie(movieName, actors);
        movieDatabase.addRating(movieName, rating);
        assertEquals(rating, movieDatabase.getMovieList().get(firstMovie).getRating(), delta);
    }

    /**
     * Best actor from database.
     */
    @Test
    public void testBestActorFromDatabase() {
        final String movieNameOne = "Rambo";
        final String[] actorsOne = new String[]{"Sylvester Stallone"};
        final int ratingOne = 20;
        final String movieNameTwo = "Titanic";
        final String[] actorsTwo = new String[]{"Leonardo DiCaprio"};
        final int ratingTwo = 10;
        final String bestActor = "Sylvester Stallone";
        movieDatabase.addMovie(movieNameOne, actorsOne);
        movieDatabase.addMovie(movieNameTwo, actorsTwo);
        movieDatabase.addRating(movieNameOne, ratingOne);
        movieDatabase.addRating(movieNameTwo, ratingTwo);
        assertEquals(bestActor, movieDatabase.getBestActor());
    }

    /**
     * Best movie from database.
     */
    @Test
    public void testBestMovieFromDatabase() {
        final String movieNameOne = "The Expendables";
        final String[] actorsOne = new String[]{"Sylvester Stallone", "Jason Statham"};
        final int ratingOne = 20;
        final String movieNameTwo = "The Expendables II";
        final String[] actorsTwo = new String[]{"Sylvester Stallone", "Jason Statham"};
        final int ratingTwo = 10;
        final String bestMovie = "The Expendables";
        movieDatabase.addMovie(movieNameOne, actorsOne);
        movieDatabase.addMovie(movieNameTwo, actorsTwo);
        movieDatabase.updateRating(movieNameOne, ratingOne);
        movieDatabase.updateRating(movieNameTwo, ratingTwo);
        assertEquals(bestMovie, movieDatabase.getBestMovie());
    }
}
