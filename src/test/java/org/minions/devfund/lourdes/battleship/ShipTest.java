package org.minions.devfund.lourdes.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Implemented tests for {@link Ship}.
 */
public class ShipTest {
    private Ocean ocean;

    /**
     * Method that setup initial values.
     */
    @Before
    public void setup() {
        ocean = new Ocean();
    }

    /**
     * Verify if the given position is ok to place.
     */
    @Test
    public void testOkToPlaceShipAt() {
        final int row = 0;
        final int column = 12;
        final boolean horizontal = false;
        Ship submarine = new Submarine();
        assertTrue(submarine.okToPlaceShipAt(row, column, horizontal, ocean));
    }

    /**
     * Verify a new ship is not positioned in an occupied place.
     */
    @Test
    public void testOkPlaceShipAtOccupiedPlace() {
        final int row = 0;
        final int column = 1;
        final boolean horizontal = false;
        Cruiser cruiser = new Cruiser();
        Destroyer destroyer = new Destroyer();
        cruiser.placeShipAt(row, column, horizontal, ocean);
        assertFalse(destroyer.okToPlaceShipAt(row, column, horizontal, ocean));
    }

    /**
     * Verify a new ship is not able to be placed next to another one.
     */
    @Test
    public void testOkPlaceShipNextToplacedShip() {
        final int rowShip1 = 2;
        final int rowColumn1 = 1;
        final int rowShip2 = 3;
        final int rowColumn2 = 4;
        final boolean horizontal = true;
        Ship submarine = new Submarine();
        Destroyer destroyer = new Destroyer();
        Cruiser cruiser = new Cruiser();
        submarine.placeShipAt(rowShip1, rowColumn1, horizontal, ocean);
        assertFalse(destroyer.okToPlaceShipAt(rowShip2, rowColumn2, horizontal, ocean));
        assertFalse(cruiser.okToPlaceShipAt(1, 1, horizontal, ocean));
    }

    /**
     * Verify place ship at the given position.
     */
    @Test
    public void testPlaceShipAt() {
        final int rowShip1 = 2;
        final int rowColumn1 = 1;
        final boolean horizontal = true;
        Ship submarine = new Submarine();
        submarine.placeShipAt(rowShip1, rowColumn1, horizontal, ocean);
        assertEquals(rowShip1, submarine.getBowRow());
        assertEquals(rowColumn1, submarine.getBowColumn());
        assertEquals(horizontal, submarine.isHorizontal());
    }

    /**
     * Verify if a ship is sunk.
     */
    @Test
    public void testIsSunk() {
        final int row = 2;
        final int column = 1;
        final int shootRow = 3;
        final int shootColumn = 4;
        final boolean horizontal = false;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        submarine.shootAt(row, column);
        submarine.shootAt(shootRow, column);
        submarine.shootAt(shootColumn, column);
        assertTrue(submarine.isSunk());
    }

    /**
     * Verify a ship is not sunk.
     */
    @Test
    public void testIsNotSunk() {
        final int row = 2;
        final int column = 1;
        final boolean horizontal = true;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        submarine.shootAt(row, column);
        submarine.shootAt(row, column);
        assertFalse(submarine.isSunk());
    }
}
