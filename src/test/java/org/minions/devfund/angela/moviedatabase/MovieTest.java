package org.minions.devfund.angela.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Movie}.
 */
public class MovieTest {
    private Movie movie;
    private static final String MOVIE_NAME = "Infinity war";

    /**
     * Preconditions.
     */
    @Before
    public void setup() {
        movie = new Movie(MOVIE_NAME);
    }

    /**
     * Verifies an movie name can be updated.
     */
    @Test
    public void testSetName() {
        final String newName = "Black Panter";
        movie.setName(newName);
        assertEquals(newName, movie.getName());
    }

    /**
     * Verifies movie's actors list can be updated.
     */
    @Test
    public void testSetActors() {
        final List<Actor> newActors = Collections.singletonList(new Actor("Tom Holland"));
        movie.setActors(newActors);
        assertEquals(newActors.get(0).getName(), movie.getActors().get(0).getName());
    }
}
