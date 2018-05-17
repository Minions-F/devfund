package org.minions.devfund.angela.battleship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link Ship}.
 */
public class ShipTest {

    private Ship ship;

    /**
     * Verifies that empty sea never sunks.
     */
    @Test
    public void testEmptySeaNeverSunks() {
        ship = new EmptySea();
        ship.setBowColumn(0);
        ship.setBowRow(0);
        assertFalse("There is a ship in that position", ship.shootAt(0, 0));
        assertFalse("The empty sea was sunk", ship.isSunk());
    }

    /**
     * Verifies if Submarine is instantiate correctly.
     */
    @Test
    public void testSubmarine() {
        ship = new Submarine();
        final int submarineLength = 3;
        assertEquals(submarineLength, ship.getLength());
    }

    /**
     * Verifies is not possible to shot a sunk ship.
     */
    @Test
    public void testShootASunkShip() {
        ship = new Submarine();
        ship.setHorizontal(false);
        ship.setBowColumn(0);
        ship.setBowRow(0);
        assertTrue("There isn't a ship in that position", ship.shootAt(0, 0));
        assertTrue("There isn't a ship in that position", ship.shootAt(1, 0));
        assertTrue("There isn't a ship in that position", ship.shootAt(2, 0));
        assertFalse("The ship isn't sunk", ship.shootAt(2, 0));
    }

    /**
     * Verifies if values of a positioned ship are set correctly.
     */
    @Test
    public void testGetBowPositionAndHorizontalValueForAPositionedShip() {
        ship = new Submarine();
        ship.setHorizontal(false);
        ship.setBowColumn(0);
        ship.setBowRow(0);
        assertFalse("The ship is horizontal", ship.getHorizontal());
        assertEquals(0, ship.getBowColumn());
        assertEquals(0, ship.getBowRow());
    }
}
