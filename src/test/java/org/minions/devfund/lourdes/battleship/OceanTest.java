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
     * Verify print method.
     */
    @Test
    public void testPrint() {
        StringBuilder expectedPrint = new StringBuilder();
        expectedPrint.append(" 00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 \n");
        expectedPrint.append("0 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("1 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("2 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("3 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
        expectedPrint.append("4 .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  . \n");
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
        assertEquals(expectedPrint.toString(), ocean.print());
    }
}
