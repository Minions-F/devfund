package org.minions.devfund.alejandro.movie.database;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class contains all test for Actor class.
 */
public class ActorTests {

    /**
     * This method verify the Actor constructor.
     */
    @Test
    public void testActorConstructor() {
        final String actorName = "test123";
        Actor actor = new Actor(actorName);
        assertThat(actor, instanceOf(Actor.class));
    }

    /**
     * This method test getName method.
     */
    @Test
    public void testActorGetName() {
        final String actorName = "test123";
        Actor actor = new Actor(actorName);
        assert actor.getName().equals(actorName);
    }

    /**
     * This method test getName method modifying a name.
     */
    @Test
    public void testActorGetNewName() {
        final String actorName = "test123";
        final String newActorName = "new name";
        Actor actor = new Actor(actorName);
        actor.setName(newActorName);
        assert actor.getName().equals(newActorName);
    }
}
