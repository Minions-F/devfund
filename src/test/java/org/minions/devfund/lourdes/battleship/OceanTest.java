package org.minions.devfund.lourdes.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Implemented tests for {@link Ocean}.
 */
public class OceanTest {
    private Ocean ocean;

    /**
     * Method that setup initial values.
     */
    @Before
    public void setup() {
        ocean = new Ocean();
    }

    /**
     * Verify the Ocean constructor.
     */
    @Test
    public void testOceanInitialization() {
        final String emptySea = "empty";
        Ship[][] shipMatrix = ocean.getShipArray();
        for (Ship[] row : shipMatrix) {
            for (Ship cellValue : row) {
                assertEquals(emptySea, cellValue.getShipType());
            }
        }
    }

    /**
     * Verify if a given position is occupied.
     */
    @Test
    public void testIsOccupied() {
        final int row = 3;
        final int column = 5;
        final boolean horizontal = true;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        for (int i = column; i < submarine.length; i++) {
            assertTrue(ocean.isOccupied(row, i));
        }
    }

    /**
     * Verify if a place is not occupied.
     */
    @Test
    public void testIsNotOccupied() {
        Ship submarine = new Submarine();
        submarine.placeShipAt(0, 0, true, ocean);
        assertFalse(ocean.isOccupied(1, 0));
    }

    /**
     * Verify shoot at position in the ocean where exists a ship.
     */
    @Test
    public void testShootAt() {
        final int row = 10;
        final int column = 5;
        final int shootRow = 10;
        final int shootColumn = 6;
        final boolean horizontal = true;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        assertTrue(ocean.shootAt(shootRow, shootColumn));
        assertTrue(ocean.shootAt(shootRow, shootColumn));
    }

    /**
     * Verify shoot in a empty place.
     */
    @Test
    public void testShootAtEmptyPosition() {
        final int row = 3;
        final int column = 2;
        final int shootRow = 10;
        final int shootColumn = 6;
        final boolean horizontal = true;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        assertFalse(ocean.shootAt(shootRow, shootColumn));
    }

    /**
     * Verify shoot at position and sunk a ship.
     */
    @Test
    public void testShootAtAndSunk() {
        final int row = 10;
        final int column = 5;
        final int shootRow = 10;
        final int shootColumn1 = 5;
        final int shootColumn2 = 6;
        final int shootColumn3 = 7;
        final boolean horizontal = true;
        final int totalShipSunk = 1;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        ocean.shootAt(shootRow, shootColumn1);
        ocean.shootAt(shootRow, shootColumn2);
        ocean.shootAt(shootRow, shootColumn3);
        assertEquals(totalShipSunk, ocean.getShipsSunk());
    }

    /**
     * Verify shoot at position and sunk a ship.
     */
    @Test
    public void testShootFired() {
        final int row = 10;
        final int column = 5;
        final int shootRow = 10;
        final int shootColumn1 = 5;
        final int shootColumn2 = 6;
        final int shootColumn3 = 7;
        final boolean horizontal = true;
        final int totalShipFired = 3;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        ocean.shootAt(shootRow, shootColumn1);
        ocean.shootAt(shootRow, shootColumn2);
        ocean.shootAt(shootRow, shootColumn3);
        assertEquals(totalShipFired, ocean.getShotsFired());
    }

    /**
     * Verify shoot at position and sunk a ship.
     */
    @Test
    public void testHitCount() {
        final int row = 10;
        final int column = 5;
        final int shootRow = 10;
        final int shootColumn1 = 5;
        final int shootColumn2 = 6;
        final int shootColumn3 = 7;
        final boolean horizontal = true;
        final int totalHitCount = 3;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        ocean.shootAt(shootRow, shootColumn1);
        ocean.shootAt(shootRow, shootColumn2);
        ocean.shootAt(shootRow, shootColumn3);
        assertEquals(totalHitCount, ocean.getShotsFired());
    }


    /**
     * Verify if a game is over.
     */
    @Test
    public void testIsGameOver() {
        ocean.placeAllShipsRandomly();
        Ship[][] shipMatrix = ocean.getShipArray();
        for (int i = 0; i < shipMatrix.length; i++) {
            for (int j = 0; j < shipMatrix.length; j++) {
                ocean.shootAt(i, j);
            }
        }
        assertTrue(ocean.isGameOver());
    }

    /**
     * Verify if a game is not over.
     */
    @Test
    public void testIsGameNotOver() {
        ocean.placeAllShipsRandomly();
        Ship[][] shipMatrix = ocean.getShipArray();
        for (int i = 0; i < shipMatrix.length; i++) {
            ocean.shootAt(i, i);
        }
        assertFalse(ocean.isGameOver());
    }


    /**
     * Verify print method.
     */
    @Test
    public void testPrint() {
        StringBuilder expectedPrint = new StringBuilder();
        expectedPrint.append(" 00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 \n");
        expectedPrint.append("0 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("1 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("2 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("3 .  .  .  .  S  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("4 .  .  .  .  -  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("5 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("6 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("7 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("8 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("9 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("10 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("11 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("12 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("13 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("14 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("15 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("16 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("17 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("18 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("19 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . ");
        final int row = 3;
        final int column = 4;
        final int shootRow = 4;
        final int shootColumn = 4;
        final boolean horizontal = true;
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        ocean.shootAt(row, column);
        ocean.shootAt(shootRow, shootColumn);
        assertEquals(expectedPrint.toString(), ocean.print());
    }
}
