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
        final String errorMessage = "There isn't a ship in that position";

        submarine.placeShipAt(0, 0, true, ocean);
        assertTrue(errorMessage, ocean.shootAt(0, 0));
        assertTrue(errorMessage, ocean.shootAt(0, 1));
        assertTrue(errorMessage, ocean.shootAt(0, 2));
        assertEquals(1, ocean.getShipsSunk());
        ocean.print();
    }

    /**
     * Verifies game finishes when all ships are sunk.
     */
    @Test
    public void testIsGameOver() {
        ocean.placeAllShipsRandomly();
        final int oceanSize = 20;
        for (int i = 0; i < oceanSize; i++) {
            for (int j = 0; j < oceanSize; j++) {
                ocean.shootAt(i, j);
            }
        }
        assertTrue("The game didn't finish", ocean.isGameOver());
    }

    /**
     * Verifies if border of a position is occupied.
     */
    @Test
    public void testBorderOccupied() {
        final Ship ship = new Submarine();
        ship.placeShipAt(0, 0, true, ocean);
        ship.placeShipAt(1, 0, true, ocean);
        ship.placeShipAt(2, 0, true, ocean);
        final String errorMessage = "Border is not occupied";
        final int thirdColumn = 3;
        assertTrue(errorMessage, ocean.isBorderOccupied(1, thirdColumn));
        assertTrue(errorMessage, ocean.isBorderOccupied(1, 1));
        assertTrue(errorMessage, ocean.isBorderOccupied(0, 1));
        assertTrue(errorMessage, ocean.isBorderOccupied(0, thirdColumn));
        assertTrue(errorMessage, ocean.isBorderOccupied(0, 2));
        assertTrue(errorMessage, ocean.isBorderOccupied(2, 1));
        assertTrue(errorMessage, ocean.isBorderOccupied(2, thirdColumn));
        assertTrue(errorMessage, ocean.isBorderOccupied(2, 2));
    }
}
