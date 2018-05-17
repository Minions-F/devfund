package org.minions.devfund.angela.battleship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link Ship}.
 */
public class ShipTest {

    private static final String MESSAGE = "There is a ship in that position";
    private Ship ship;

    /**
     * Verifies that empty sea never sunks.
     */
    @Test
    public void testEmptySeaNeverSunks() {
        ship = new EmptySea();
        ship.setBowColumn(0);
        ship.setBowRow(0);
        assertFalse(MESSAGE, ship.shootAt(0, 0));
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
        ship.setBowColumn(1);
        ship.setBowRow(1);
        final String errorMessage = "There isn't a ship in that position";
        assertTrue(errorMessage, ship.shootAt(1, 1));
        assertTrue(errorMessage, ship.shootAt(2, 1));
        assertEquals("S", ship.toString());
        final int thirdRow = 3;
        assertTrue(errorMessage, ship.shootAt(thirdRow, 1));
        assertEquals("x", ship.toString());
        assertFalse("The ship isn't sunk", ship.shootAt(1, 1));
    }

    /**
     * Verifies shoot an horizontal ship.
     */
    @Test
    public void testShootAHorizontalShip() {
        ship = new Submarine();
        ship.setHorizontal(true);
        ship.setBowColumn(1);
        ship.setBowRow(1);
        final String errorMessage = "There isn't a ship in that position";
        assertTrue(errorMessage, ship.shootAt(1, 1));
        assertTrue(errorMessage, ship.shootAt(1, 2));
        assertEquals("S", ship.toString());
        final int thirdColumn = 3;
        assertTrue(errorMessage, ship.shootAt(1, thirdColumn));
        assertEquals("x", ship.toString());
        assertFalse("The ship isn't sunk", ship.shootAt(1, 1));

    }

    /**
     * Verifies a shoot was missed in a vertical ship.
     */
    @Test
    public void testVerticalMissingShoot() {
        ship = new Submarine();
        ship.setHorizontal(false);
        ship.setBowColumn(1);
        ship.setBowRow(1);
        final int forthRow= 4;

        assertFalse(MESSAGE, ship.shootAt(0, 1));
        assertFalse(MESSAGE, ship.shootAt(forthRow, 1));
        assertFalse(MESSAGE, ship.shootAt(1, 0));
        assertFalse(MESSAGE, ship.shootAt(2, 2));
    }

    /**
     * Verifies a shoot was missed in a horizontal ship.
     */
    @Test
    public void testHorizontalMissingShoot() {
        ship = new Submarine();
        ship.setHorizontal(true);
        ship.setBowColumn(1);
        ship.setBowRow(1);
        final int forthColumn = 4;

        assertFalse(MESSAGE, ship.shootAt(1, 0));
        assertFalse(MESSAGE, ship.shootAt(1, forthColumn));
        assertFalse(MESSAGE, ship.shootAt(0, 1));
        assertFalse(MESSAGE, ship.shootAt(2, 1));
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
