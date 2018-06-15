package org.minions.devfund.lourdes.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Implemented tests for {@link Submarine}.
 */
public class SubmarineTest {
    private Submarine submarine;

    /**
     * Method that setup initial values.
     */
    @Before
    public void setup() {
        submarine = new Submarine();
    }

    /**
     * Verify LightCruiser constructor.
     */
    @Test
    public void testSubmarineInitialization() {
        final int expectedLenght = 3;
        final boolean[] expectedHit = new boolean[expectedLenght];
        assertEquals(expectedLenght, submarine.length);
        assertArrayEquals(expectedHit, submarine.hit);
    }

    /**
     * Verify Submarine ship type.
     */
    @Test
    public void getShipType() {
        final String expType = "submarine";
        assertEquals(expType, submarine.getShipType());
    }
}
