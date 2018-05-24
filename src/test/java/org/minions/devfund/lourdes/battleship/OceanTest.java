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
        Ocean ocean = new Ocean();
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
}
