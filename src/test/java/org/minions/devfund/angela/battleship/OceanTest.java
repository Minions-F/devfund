package org.minions.devfund.angela.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test for {@link Ocean} .
 */
public class OceanTest {
    private Ocean ocean;

    /**
     * Preconditions.
     */
    @Before
    public void setup() {
        ocean = new Ocean();
    }

    /**
     * Verifies if is printing.
     */
    @Test
    public void testInitialValues() {
        ocean.placeAllShipsRandomly();
        assertFalse("Is game over", ocean.isGameOver());
        assertEquals(0, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(0, ocean.getShotsFired());

        ocean.print();
    }
}
