package org.minions.devfund.marcos.moviedatabase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * It is in charged to define the unit tests for Movie Database class.
 */
public class MovieDatabaseTest {

    private static final int FIRST_MOVIE_INDEX = 0;
    private static final double DELTA = 0;

    /**
     * New Movie Database object has empty actors and movies lists.
     */
    @Test
    public void testNewMovieDatabaseHasEmptyActorsAndMoviesLists() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        assertTrue(movieDatabase.getMovieList().isEmpty());
        assertTrue(movieDatabase.getActorList().isEmpty());
    }

    /**
     * Add new movie object to database.
     */
    @Test
    public void testAddMovieToDatabase() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movieTitle = "Interstellar";
        final String[] actors = new String[]{"Anne Hathaway", "Matthew McConaughey"};
        final int expectedMovieListSize = 1;
        final int expectedActorsListSize = 2;
        movieDatabase.addMovie(movieTitle, actors);
        assertEquals(expectedMovieListSize, movieDatabase.getMovieList().size());
        assertEquals(expectedActorsListSize, movieDatabase.getActorList().size());
    }

    /**
     * Add duplicated movie object to database.
     */
    @Test
    public void testAddDuplicatedMovieToDatabase() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movieTitle = "Interstellar";
        final String[] actors = new String[]{"Anne Hathaway", "Matthew McConaughey"};
        final int expectedMovieListSize = 1;
        final int expectedActorsListSize = 2;
        movieDatabase.addMovie(movieTitle, actors);
        movieDatabase.addMovie(movieTitle, actors);
        assertEquals(expectedMovieListSize, movieDatabase.getMovieList().size());
        assertEquals(expectedActorsListSize, movieDatabase.getActorList().size());
    }

    /**
     * Add new movie rating to existing movie object in database.
     */
    @Test
    public void testAddMovieRatingToDatabase() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movieTitle = "Bohemian Rhapsody";
        final String[] actors = new String[]{"Rami Malek", "Ben Hardy"};
        final int newMovieRating = 10;
        movieDatabase.addMovie(movieTitle, actors);
        movieDatabase.addRating(movieTitle, newMovieRating);
        assertEquals(newMovieRating, movieDatabase.getMovieList().get(FIRST_MOVIE_INDEX).getRating(), DELTA);
    }

    /**
     * Get best actor from movie database.
     */
    @Test
    public void testGetBestActorFromDatabase() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movieOneTitle = "Bohemian Rhapsody";
        final String[] movieOneActors = new String[]{"Rami Malek"};
        final int movieOneRating = 10;
        final String movieTwoTitle = "Zoolander";
        final String[] movieTwoActors = new String[]{"RChristian Slater"};
        final int movieTwoRating = 7;
        final String expectedBestActor = "Rami Malek";
        movieDatabase.addMovie(movieOneTitle, movieOneActors);
        movieDatabase.addMovie(movieTwoTitle, movieTwoActors);
        movieDatabase.addRating(movieOneTitle, movieOneRating);
        movieDatabase.addRating(movieTwoTitle, movieTwoRating);
        assertEquals(expectedBestActor, movieDatabase.getBestActor());
    }

    /**
     * Get best movie from movie database.
     */
    @Test
    public void testGetBestMovieFromDatabase() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movieOneTitle = "Bohemian Rhapsody";
        final String[] movieOneActors = new String[]{"Rami Malek", "Aidan Gillen"};
        final int movieOneRating = 10;
        final String movieTwoTitle = "Zoolander";
        final String[] movieTwoActors = new String[]{"RChristian Slater", "Owen Wilson"};
        final int movieTwoRating = 7;
        final String expectedBestMovie = "Bohemian Rhapsody";
        movieDatabase.addMovie(movieOneTitle, movieOneActors);
        movieDatabase.addMovie(movieTwoTitle, movieTwoActors);
        movieDatabase.updateRating(movieOneTitle, movieOneRating);
        movieDatabase.updateRating(movieTwoTitle, movieTwoRating);
        assertEquals(expectedBestMovie, movieDatabase.getBestMovie());
    }
}
