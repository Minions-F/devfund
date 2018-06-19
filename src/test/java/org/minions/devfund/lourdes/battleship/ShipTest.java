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
     * Verify if the given position is ok to place a vertical ship.
     */
    @Test
    public void testVerticalOkToPlaceShipAt() {
        final int row = 0;
        final int column = 12;
        final boolean horizontal = false;
        Ship submarine = new Submarine();
        assertTrue(submarine.okToPlaceShipAt(row, column, horizontal, ocean));
    }

    /**
     * Verify if the given position is ok to place a horizontal ship.
     */
    @Test
    public void testHorizontalOkToPlaceShipAt() {
        final int row = 4;
        final int column = 12;
        final boolean horizontal = true;
        Ship submarine = new Submarine();
        assertTrue(submarine.okToPlaceShipAt(row, column, horizontal, ocean));
    }

    /**
     * Verify a new vertical ship is not positioned in an occupied place.
     */
    @Test
    public void testVerticalOkPlaceShipAtOccupiedPlace() {
        final int row = 0;
        final int column = 1;
        final boolean horizontal = false;
        Cruiser cruiser = new Cruiser();
        Destroyer destroyer = new Destroyer();
        cruiser.placeShipAt(row, column, horizontal, ocean);
        assertFalse(destroyer.okToPlaceShipAt(row, column, horizontal, ocean));
    }

    /**
     * Verify a new horizontal ship is not positioned in an occupied place.
     */
    @Test
    public void testHorizontalOkPlaceShipAtOccupiedPlace() {
        final int row = 0;
        final int column = 1;
        final boolean horizontal = true;
        Cruiser cruiser = new Cruiser();
        Destroyer destroyer = new Destroyer();
        cruiser.placeShipAt(row, column, horizontal, ocean);
        assertFalse(destroyer.okToPlaceShipAt(row, column, horizontal, ocean));
    }

    /**
     * Verify a new ship is not positioned in an invalid place.
     */
    @Test
    public void testOkPlaceShipAtLimitPlace() {
        final int row = 10;
        final int column = 15;
        final boolean horizontal = true;
        Cruiser cruiser = new Cruiser();
        assertFalse(cruiser.okToPlaceShipAt(row, column, horizontal, ocean));
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
     * Verify a new ship is not able to be placed next to another one.
     */
    @Test
    public void testOkPlaceShipNextToDiagonalPlacedShip() {
        final int rowShip1 = 2;
        final int rowColumn1 = 1;
        final int rowShip2 = 5;
        final int rowColumn2 = 2;
        final boolean horizontal = false;
        Ship submarine = new Submarine();
        Destroyer destroyer = new Destroyer();
        submarine.placeShipAt(rowShip1, rowColumn1, horizontal, ocean);
        assertFalse(destroyer.okToPlaceShipAt(rowShip2, rowColumn2, horizontal, ocean));
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
        final int shootRow1 = 2;
        final int shootRow2 = 3;
        final int shootRow3 = 4;
        final String isSunk = "x";
        final boolean horizontal = false;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        submarine.shootAt(shootRow1, column);
        submarine.shootAt(shootRow2, column);
        submarine.shootAt(shootRow3, column);
        assertTrue(submarine.isSunk());
        assertEquals(isSunk, submarine.toString());
    }

    /**
     * Verify a ship is not sunk.
     */
    @Test
    public void testIsNotSunk() {
        final int row = 2;
        final int column = 1;
        final boolean horizontal = true;
        final String expectedValue = "S";
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        submarine.shootAt(row, column);
        submarine.shootAt(row, column);
        assertFalse(submarine.isSunk());
        assertEquals(expectedValue, submarine.toString());
    }

    /**
     * Verify a shoot at empty position.
     */
    @Test
    public void testShootAtEmptySea() {
        final int row = 2;
        final int column = 1;
        final int rowEmpty = 10;
        final int columnEmpty = 5;
        final boolean horizontal = true;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        assertFalse(submarine.shootAt(rowEmpty, columnEmpty));
    }

    /**
     * Verify shoots in valid horizontal position of a ship.
     */
    @Test
    public void testHorizontalShootAtValidPosition() {
        final int row = 2;
        final int column = 1;
        final int shootColumn1 = 2;
        final int shootColumn2 = 3;
        final boolean horizontal = true;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        submarine.shootAt(row, shootColumn1);
        assertTrue(submarine.shootAt(row, shootColumn1));
        assertTrue(submarine.shootAt(row, shootColumn2));
    }

    /**
     * Verify shoots in valid Vertical position of a ship.
     */
    @Test
    public void testVerticalShootAtValidPosition() {
        final int row = 2;
        final int column = 1;
        final int shootRow1 = 2;
        final int shootRow2 = 3;
        final int shootRow3 = 4;
        final boolean horizontal = false;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        assertTrue(submarine.shootAt(shootRow1, column));
        assertTrue(submarine.shootAt(shootRow2, column));
        assertTrue(submarine.shootAt(shootRow3, column));
    }

    /**
     * Verify a set bow column and row.
     */
    @Test
    public void testSetHeadShip() {
        final int row = 2;
        final int column = 1;
        Ship submarine = new Submarine();
        submarine.setBowRow(row);
        submarine.setBowColumn(column);
        assertEquals(row, submarine.getBowRow());
        assertEquals(column, submarine.getBowColumn());
    }

    /**
     * Verify set length to a ship.
     */
    @Test
    public void tesShipLength() {
        final int length = 3;
        final int expectedLength = 3;
        Ship submarine = new Submarine();
        submarine.setLength(length);
        assertEquals(expectedLength, submarine.getLength());
    }

    /**
     * Verify set orientation of a ship.
     */
    @Test
    public void testShipHorizontal() {
        final boolean horizontal = true;
        Ship submarine = new Submarine();
        submarine.setHorizontal(horizontal);
        assertEquals(horizontal, submarine.isHorizontal());
    }

    /**
     * Test toString method for EmptySea that was not shot.
     */
    @Test
    public void testToStringEmptySeaNotShoot() {
        final String emptySeaNotShoot = ".";
        Ship[][] shipMatrix = ocean.getShipArray();
        for (Ship[] row : shipMatrix) {
            for (Ship cellValue : row) {
                assertEquals(emptySeaNotShoot, cellValue.toString());
            }
        }
    }

    /**
     * Test toString method for Empty sea that was shot.
     */
    @Test
    public void testToStringEmptySeaShoot() {
        final String emptySeaNotShoot = "-";
        final int row = 3;
        final int column = 4;
        Ship[][] shipMatrix = ocean.getShipArray();
        ocean.shootAt(row, column);
        assertEquals(emptySeaNotShoot, shipMatrix[row][column].toString());
    }
}
