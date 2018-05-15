package org.minions.devfund.dennis;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Unit Test class for Actor with all methods.
 */
public class ActorTest {
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
        final Actor actor = new Actor("Robert De Niro");
        final String actorName = "Robert De Niro";
        assertEquals(actorName, actor.getName());
    }

    /**
     * Set actor name with with not empty name.
     */
    @Test
    public void testSetActorName() {
        final Actor actor = new Actor("Tom Hanks");
        final String actorName = "Tom Hanks II";
        actor.setName(actorName);
        assertEquals(actorName, actor.getName());
    }

    /**
     * Set actor with movies.
     */
    @Test
    public void testSetActorWithMovies() {
        final Actor actor = new Actor("Leonardo DiCaprio");
        final List<Movie> movies = Arrays.asList(new Movie("Titanic"),
                new Movie("The Wolf of Wall Street"));
        actor.setMovies(movies);
        assertEquals(movies, actor.getMovies());
    }

    /**
     * get the rating of movies of each actor.
     */
    @Test
    public void testActorWithMovieGettingTheRating() {
        final Actor actor = new Actor("Robert De Niro");
        final double ratingMovieOne = 8;
        final double ratingMovieTwo = 4;
        final double getRating = (ratingMovieOne + ratingMovieTwo) / 2;
        final double delta = 0;
        final Movie movieOne = new Movie("Black Swan");
        movieOne.setRating(ratingMovieOne);
        final Movie movieTwo = new Movie("Jane Got a Gun");
        movieTwo.setRating(ratingMovieTwo);
        actor.getMovies().add(movieOne);
        actor.getMovies().add(movieTwo);
        assertEquals(getRating, actor.getActorRating(), delta);
    }
}
