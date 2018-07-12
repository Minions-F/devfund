package org.minions.devfund.mauricioz;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * movie class tests.
 */
public class MovieTest {
    private Movie movie;

    /**
     * before setup for executions.
     */
    @Before
    public void setUp() {
        movie = new Movie("movie name");
    }

    /**
     * test movie object is instance of movie class.
     */
    @Test
    public void testIsInstanceOfMovie() {
        assertThat(movie, instanceOf(Movie.class));
    }

    /**
     * test movie name getter and setter methods.
     */
    @Test
    public void testUpdateMovieName() {
        String newMovieName = "New Movie Name";
        movie.setName(newMovieName);
        assertEquals(newMovieName, movie.getName());
    }

    /**
     * test rating getter and setter methods.
     */
    @Test
    public void testRaitingGetSet() {
        final double newRating = 8.3;
        movie.setRating(newRating);
        assertEquals(newRating, movie.getRating());
    }

    /**
     * test getters and setters for actors.
     */
    @Test
    public void testactorsGetSet() {
        Actor actor = new Actor();
        actor.setName("actor name");
        List<Actor> actors = new ArrayList<>();
        actors.add(actor);
        movie.setActors(actors);
        assertEquals(actor.getName(), movie.getActors().get(0).getName());
    }
}
