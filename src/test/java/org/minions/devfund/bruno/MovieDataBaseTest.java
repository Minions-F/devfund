package org.minions.devfund.bruno;

import org.junit.Before;
import org.junit.Test;
import org.minions.devfund.bruno.moviedatabase.MovieDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

/**
 * It is in charged to define the unit tests for Movie Data Base class.
 */
public class MovieDataBaseTest {

    private MovieDatabase movieDataBase;

    /**
     * Setup movie data base.
     */
    @Before
    public void setup() {
        movieDataBase = new MovieDatabase();
        movieDataBase.main();
    }

    /**
     * Actors length test.
     */
    @Test
    public void testActorsLength() {
        final int expectedLength = 121;
        int actualLength = movieDataBase.getActorList().size();
        assertEquals(expectedLength, actualLength);
    }

    /**
     * Test to movies length.
     */
    @Test
    public void testMoviesLength() {
        final int expectedLength = 315;
        int actualLength = movieDataBase.getMovieList().size();
        assertEquals(expectedLength, actualLength);
    }

    /**
     * Test to add new movie with new actors.
     */
    @Test
    public void testAddNewMovieWithNewActors() {
        final int expectedMovieLength = 316;
        final int expectedActorLength = 124;
        final String[] actors = {"capitan", "pantera", "tanos"};
        final String movieName = "Avengers Infinity Wars";
        movieDataBase.addMovie(movieName, actors);
        int actualMovieLength = movieDataBase.getMovieList().size();
        int actualActorLength = movieDataBase.getActorList().size();
        assertEquals(expectedMovieLength, actualMovieLength);
        assertEquals(expectedActorLength, actualActorLength);
    }

    /**
     * Test to add old movie with two new actors and one old actor.
     */
    @Test
    public void testAddOldMovieWithNewActors() {
        final int expectedMovieLength = 315;
        final int expectedActorLength = 123;
        final String[] actors = {"capitan", "James McAvoy", "tanos"};
        final String movieName = "Cold Mountain";
        movieDataBase.addMovie(movieName, actors);
        int actualMovieLength = movieDataBase.getMovieList().size();
        int actualActorLength = movieDataBase.getActorList().size();
        assertEquals(expectedMovieLength, actualMovieLength);
        assertEquals(expectedActorLength, actualActorLength);
    }

    /**
     * Test updates movie rating.
     */
    @Test
    public void testUpdateMovieRating() {
        final String movieName = "Apollo 13";
        final double expectedRating = 96;
        movieDataBase.updateRating(movieName, expectedRating);
        double actualRaring = Objects.requireNonNull(movieDataBase.getMovieList().stream().filter(movie
                -> movie.getName().equals(movieName)).findFirst().orElse(null)).getRating();
        assertEquals(expectedRating, actualRaring, 0);
    }

    /**
     * Test to read the file with error path.
     */
    @Test
    public void testReadFileWithErrorPath() {
        final List<String> expectedFile = new ArrayList<>();
        List<String> actualFile = movieDataBase.readDataBase("error/path");
        assertEquals(expectedFile.size(), actualFile.size());
    }


    /**
     * Test only should be exist one object whit this name.
     */
    @Test
    public void testTheBestMovie() {
        String theBestMovieExpected = "The Philadelphia Story";
        String theBestMovieActual = movieDataBase.getBestMovie();
        assertEquals(theBestMovieExpected, theBestMovieActual);
    }

    /**
     * Test it should be exist one object whit this name.
     */
    @Test
    public void testTheBestActor() {
        String theBestActorExpected = "George Scott";
        String theBestActorActual = movieDataBase.getBestActor();
        assertEquals(theBestActorExpected, theBestActorActual);
    }

    /**
     * Test to actors length in the movie.
     */
    @Test
    public void testTheActorLengthInTheMovie() {
        final String movieName = "Apollo 13";
        final int expectedActorsLength = 2;
        final int actualActorsLength = Objects.requireNonNull(movieDataBase.getMovieList().stream().filter(movie
                -> movie.getName().equals(movieName)).findFirst().orElse(null)).getActors().size();

        assertEquals(expectedActorsLength, actualActorsLength);
    }
}
