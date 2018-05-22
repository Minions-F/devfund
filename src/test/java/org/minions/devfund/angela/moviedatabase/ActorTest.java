package org.minions.devfund.angela.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Actor}.
 */
public class ActorTest {

    private Actor actor;
    private static final String ACTOR_NAME = "Tom Holland";

    /**
     * Preconditions.
     */
    @Before
    public void setup() {
        actor = new Actor(ACTOR_NAME);
    }

    /**
     * Verifies an actor name can be updated.
     */
    @Test
    public void testSetName() {
        final String newName = "Josh Brolin";
        actor.setName(newName);
        assertEquals(newName, actor.getName());
    }

    /**
     * Verifies actor's movies list can be updated.
     */
    @Test
    public void testSetMovies() {
        final List<Movie> newMovies = Collections.singletonList(new Movie("Infinity War"));
        actor.setMovies(newMovies);
        assertEquals(newMovies.get(0).getName(), actor.getMovies().get(0).getName());
    }
}
