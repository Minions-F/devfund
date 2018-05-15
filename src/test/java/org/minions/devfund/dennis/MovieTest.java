package org.minions.devfund.dennis;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Unit Test class for Movie with all methods.
 */
public class MovieTest {
    private static final String ACTOR_ONE = "Robert De Niro";
    private static final String ACTOR_TWO = "Leonardo DiCaprios";
    private static final String MOVIE_ONE = "Titanic";
    private static final String MOVIE_TWO = "The Wolf of Wall Street";

    /**
     * Unit test for New Movie with empty name.
     */
    @Test
    public void testNewMovieAndEmptyName() {
        final Movie movie = new Movie();
        final String emptyName = "";
        assertEquals(emptyName, movie.getName());
    }

    /**
     * Unit test for New Movie with not empty name.
     */
    @Test
    public void testNewMovieWithAName() {
        final Movie movie = new Movie(MOVIE_ONE);
        assertEquals(MOVIE_ONE, movie.getName());
    }

    /**
     * Set movie name with with not empty name.
     */
    @Test
    public void testSetMovieName() {
        final Movie movie = new Movie(MOVIE_ONE);
        movie.setName(MOVIE_TWO);
        assertEquals(MOVIE_TWO, movie.getName());
    }

    /**
     * Set movie with actors.
     */
    @Test
    public void testSetMovieWithActors() {
        final Movie movie = new Movie(MOVIE_ONE);
        final List<Actor> actors = Arrays.asList(new Actor(ACTOR_ONE), new Actor(ACTOR_TWO));
        movie.setActors(actors);
        assertEquals(actors, movie.getActors());
    }

    /**
     * set movie rating.
     */
    @Test
    public void testSetMovieRating() {
        final Movie movie = new Movie(MOVIE_ONE);
        final double rating = 20;
        final double delta = 0;
        movie.setRating(rating);
        assertEquals(rating, movie.getRating(), delta);
    }
}
