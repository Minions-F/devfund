package org.minions.devfund.lourdes.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Implemented tests for {@link Cruiser}.
 */
public class CruiserTest {
    private Cruiser cruiser;

    /**
     * Method that setup initial values.
     */
    @Before
    public void setup() {
        cruiser = new Cruiser();
    }

    /**
     * Verify Cruiser constructor.
     */
    @Test
    public void testCruiserInitialization() {
        final int expectedLenght = 6;
        final boolean[] expectedHit = new boolean[expectedLenght];
        assertEquals(expectedLenght, cruiser.length);
        assertArrayEquals(expectedHit, cruiser.hit);
    }

    /**
     * Verify Cruiser type.
     */
    @Test
    public void getShipType() {
        final String expType = "cruiser";
        assertEquals(expType, cruiser.getShipType());
    }
}
