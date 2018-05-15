package org.minions.devfund.dennis;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Unit Test class for Movie with all methods.
 */
public class MovieTest {
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
        final Movie movie = new Movie("Act of Valor");
        final String movieName = "Act of Valor";
        assertEquals(movieName, movie.getName());
    }

    /**
     * Set movie name with with not empty name.
     */
    @Test
    public void testSetMovieName() {
        final Movie movie = new Movie("American Gangster");
        final String movieName = "American Gangster II";
        movie.setName(movieName);
        assertEquals(movieName, movie.getName());
    }

    /**
     * Set movie with actors.
     */
    @Test
    public void testSetMovieWithActors() {
        final Movie movie = new Movie("The Expendables");
        final List<Actor> actors = Arrays.asList(new Actor("Sylvester Stallone"),
                new Actor("Jason Statham"));
        movie.setActors(actors);
        assertEquals(actors, movie.getActors());
    }

    /**
     * set movie rating.
     */
    @Test
    public void testSetMovieRating() {
        final Movie movie = new Movie("American Pie");
        final double rating = 20;
        final double delta = 0;
        movie.setRating(rating);
        assertEquals(rating, movie.getRating(), delta);
    }
}
