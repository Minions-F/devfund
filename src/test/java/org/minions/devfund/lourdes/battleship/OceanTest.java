package org.minions.devfund.lourdes.battleship;

import org.junit.Test;

import static org.junit.Assert.*;

public class OceanTest {

    @Test
    public void testOceanInitialization() {
        Ocean ocean = new Ocean();
        Ship[][] shipMatrix = ocean.getShipArray();
        for (Ship[] row : shipMatrix) {
            for (Ship cellValue : row) {
                assertEquals(cellValue.getShipType(), "empty");
            }
        }
    }

    @Test
    public void testIsOccupied() {
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        submarine.placeShipAt(0, 0, true, ocean);
        for (int i = 0; i < submarine.lenght; i++) {
            assertTrue(ocean.isOccupied(0, i));
        }


    }

    @Test
    public void testIsNotOccupied() {
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        submarine.placeShipAt(0, 0, true, ocean);
        assertFalse(ocean.isOccupied(1, 0));

    }

}