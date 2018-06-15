package org.minions.devfund.lourdes.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Implemented tests for {@link LightCruiser}.
 */
public class LightCruiserTest {
    private LightCruiser lightCruiser;

    /**
     * Method that setup initial values.
     */
    @Before
    public void setup() {
        lightCruiser = new LightCruiser();
    }

    /**
     * Verify LightCruiser constructor.
     */
    @Test
    public void testLightCruiserInitialization() {
        final int expectedLenght = 5;
        final boolean[] expectedHit = new boolean[expectedLenght];
        assertEquals(expectedLenght, lightCruiser.length);
        assertArrayEquals(expectedHit, lightCruiser.hit);
    }

    /**
     * Verify Ship Type.
     */
    @Test
    public void getShipType() {
        final String expType = "lightcruiser";
        assertEquals(expType, lightCruiser.getShipType());
    }
}
