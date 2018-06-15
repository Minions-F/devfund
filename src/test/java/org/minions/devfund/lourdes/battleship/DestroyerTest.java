package org.minions.devfund.lourdes.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Implemented tests for {@link Destroyer}.
 */
public class DestroyerTest {
    private Destroyer destroyer;

    /**
     * Method that setup initial values.
     */
    @Before
    public void setup() {
        destroyer = new Destroyer();
    }

    /**
     * Verify Destroyer constructor.
     */
    @Test
    public void testDestroyerInitialization() {
        final int expectedLenght = 4;
        final boolean[] expectedHit = new boolean[expectedLenght];
        assertEquals(expectedLenght, destroyer.length);
        assertArrayEquals(expectedHit, destroyer.hit);
    }

    /**
     * Verify Destroyer ship type.
     */
    @Test
    public void getShipType() {
        final String expType = "destroyer";
        assertEquals(expType, destroyer.getShipType());
    }
}
