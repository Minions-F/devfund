package org.minions.devfund.dennis;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Unit Test class for Actor with all methods.
 */
public class ActorTest {
    private static final String ACTOR_ONE = "Robert De Niro";
    private static final String ACTOR_TWO = "Leonardo DiCaprios";
    private static final String MOVIE_ONE = "Titanic";
    private static final String MOVIE_TWO = "The Wolf of Wall Street";

    /**
     * Unit test for New Actor with empty name.
     */
    @Test
    public void testNewActorAndEmptyName() {
        final Actor actor = new Actor();
        final String emptyName = "";
        assertEquals(emptyName, actor.getName());
    }

    /**
     * Unit test for New Actor with not empty name.
     */
    @Test
    public void testNewActorWithAName() {
        final Actor actor = new Actor(ACTOR_ONE);
        assertEquals(ACTOR_ONE, actor.getName());
    }

    /**
     * Set actor name with with not empty name.
     */
    @Test
    public void testSetActorName() {
        final Actor actor = new Actor(ACTOR_ONE);
        actor.setName(ACTOR_TWO);
        assertEquals(ACTOR_TWO, actor.getName());
    }

    /**
     * Set actor with movies.
     */
    @Test
    public void testSetActorWithMovies() {
        final Actor actor = new Actor(ACTOR_TWO);
        final List<Movie> movies = Arrays.asList(new Movie(MOVIE_ONE), new Movie(MOVIE_TWO));
        actor.setMovies(movies);
        assertEquals(movies, actor.getMovies());
    }

    /**
     * get the rating of movies of each actor.
     */
    @Test
    public void testActorWithMovieGettingTheRating() {
        final Actor actor = new Actor(ACTOR_TWO);
        final double ratingMovieOne = 8;
        final double ratingMovieTwo = 4;
        final double getRating = (ratingMovieOne + ratingMovieTwo) / 2;
        final double delta = 0;
        final Movie movieOneR = new Movie(MOVIE_ONE);
        movieOneR.setRating(ratingMovieOne);
        final Movie movieTwoR = new Movie(MOVIE_TWO);
        movieTwoR.setRating(ratingMovieTwo);
        actor.getMovies().add(movieOneR);
        actor.getMovies().add(movieTwoR);
        assertEquals(getRating, actor.getActorRating(), delta);
    }
}
