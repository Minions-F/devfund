package org.minions.devfund.dennis.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Unit Test class for MovieDatabase with all methods.
 */
public class MovieDatabaseTest {
    private MovieDatabase movieDatabase;
    private static final String ACTOR_ONE = "Sylvester Stallone";
    private static final String ACTOR_TWO = "Jason Statham";
    private static final String MOVIE_ONE = "The Expendables";
    private static final String MOVIE_TWO = "The Expendables II";

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
        final String[] actors = new String[]{ACTOR_ONE, ACTOR_TWO};
        final int movieList = 1;
        final int actorList = 2;
        movieDatabase.addMovie(MOVIE_ONE, actors);
        assertEquals(movieList, movieDatabase.getMovieList().size());
        assertEquals(actorList, movieDatabase.getActorList().size());
    }

    /**
     * Add duplicated movies to database.
     */
    @Test
    public void testDuplicatedMovieToDatabaseWithActors() {
        final String[] actors = new String[]{ACTOR_ONE, ACTOR_TWO};
        final int movieList = 1;
        final int actorList = 2;
        movieDatabase.addMovie(MOVIE_ONE, actors);
        movieDatabase.addMovie(MOVIE_ONE, actors);
        assertEquals(movieList, movieDatabase.getMovieList().size());
        assertEquals(actorList, movieDatabase.getActorList().size());
    }

    /**
     * Add duplicated actors to database.
     */
    @Test
    public void testDuplicatedActorsToDatabaseWithMovie() {
        final String[] actorsOne = new String[]{ACTOR_ONE, ACTOR_TWO};
        final String[] actorsTwo = new String[]{ACTOR_ONE, ACTOR_TWO};
        final int movieList = 2;
        final int actorList = 2;
        movieDatabase.addMovie(MOVIE_ONE, actorsOne);
        movieDatabase.addMovie(MOVIE_TWO, actorsTwo);
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
        final String[] actors = new String[]{ACTOR_ONE, ACTOR_TWO};
        final int rating = 10;
        movieDatabase.addMovie(MOVIE_ONE, actors);
        movieDatabase.addRating(MOVIE_ONE, rating);
        assertEquals(rating, movieDatabase.getMovieList().get(firstMovie).getRating(), delta);
    }

    /**
     * Best actor from database.
     */
    @Test
    public void testBestActorFromDatabase() {
        final String[] actorsOne = new String[]{ACTOR_ONE};
        final int ratingOne = 20;
        final String[] actorsTwo = new String[]{ACTOR_TWO};
        final int ratingTwo = 10;
        movieDatabase.addMovie(MOVIE_ONE, actorsOne);
        movieDatabase.addMovie(MOVIE_TWO, actorsTwo);
        movieDatabase.addRating(MOVIE_ONE, ratingOne);
        movieDatabase.addRating(MOVIE_TWO, ratingTwo);
        assertEquals(ACTOR_ONE, movieDatabase.getBestActor());
    }

    /**
     * Best movie from database.
     */
    @Test
    public void testBestMovieFromDatabase() {
        final String[] actorsOne = new String[]{ACTOR_ONE, ACTOR_TWO};
        final int ratingOne = 20;
        final String[] actorsTwo = new String[]{ACTOR_ONE, ACTOR_TWO};
        final int ratingTwo = 10;
        movieDatabase.addMovie(MOVIE_ONE, actorsOne);
        movieDatabase.addMovie(MOVIE_TWO, actorsTwo);
        movieDatabase.updateRating(MOVIE_ONE, ratingOne);
        movieDatabase.updateRating(MOVIE_TWO, ratingTwo);
        assertEquals(MOVIE_ONE, movieDatabase.getBestMovie());
    }
}
