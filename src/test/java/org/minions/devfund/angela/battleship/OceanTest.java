package org.minions.devfund.angela.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    /**
     * Verifies a shot was done successfully.
     */
    @Test
    public void testShootAtOcean() {
        assertEquals(".", ocean.getShipArray()[0][0].toString());
        assertFalse("There isn't an empty sea", ocean.shootAt(0, 0));
        assertFalse("Empty sea is sunk", ocean.getShipArray()[0][0].isSunk());
        assertEquals("-", ocean.getShipArray()[0][0].toString());
        ocean.print();
    }

    /**
     * Verifies a shot was done successfully.
     */
    @Test
    public void testSunkShip() {
        final Ship submarine = new Submarine();
        submarine.placeShipAt(0, 0, true, ocean);
        assertTrue("There isn't a ship in that position", ocean.shootAt(0, 0));
        assertTrue("There isn't a ship in that position", ocean.shootAt(0, 1));
        assertTrue("There isn't a ship in that position", ocean.shootAt(0, 2));
        assertEquals(1, ocean.getShipsSunk());
        ocean.print();
    }
}
