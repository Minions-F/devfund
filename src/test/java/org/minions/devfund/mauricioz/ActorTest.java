package org.minions.devfund.mauricioz;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * This class is a set of unit tests for Actor class methods.
 *
 * @author Mauricio Zelaya
 * @version 1.0
 */
public class ActorTest {
    private Actor actor;
    private Movie mov1;
    private Movie mov2;

    /**
     * before setup of execution.
     */
    @Before
    public void setUp() {
        List<Movie> movies;
        actor = new Actor();
        mov1 = new Movie("Avengers Infinity War");
        mov2 = new Movie("Iron Man");
        movies = new ArrayList<>();
        movies.add(mov1);
        movies.add(mov2);
        actor.setMovies(movies);
    }
    /**
     * test that actor created is an instance of Actor class.
     */
    @Test
    public void testActorIsInstanceOfActorClass() {

        assertThat(actor, instanceOf(Actor.class));
    }

    /**
     * testing getter and setter for name.
     */
    @Test
    public void testIsPossibleChangeAnActorName() {
        String newName = "new Name";
        actor.setName(newName);
        assertEquals(newName, actor.getName());
    }

    /**
     * testing average of the movies where actor acts.
     */
    @Test
    public void testActingAverage() {
        final double rating1 = 10.0;
        final double rating2 = 8.5;
        final double ratingAvg = (rating1 + rating2) / 2;
        final double delta = 0.001;
        mov1.setRating(rating1);
        mov2.setRating(rating2);

        assertEquals(ratingAvg, actor.ratingAverage(), delta);
    }

    /**
     * test get movies for an actor.
     */
    @Test
    public void testGetMovies() {
        List<Movie> moviesOfActor = new ArrayList<>();
        moviesOfActor.add(mov1);
        moviesOfActor.add(mov2);

        assertEquals(moviesOfActor, actor.getMovies());

    }

}
