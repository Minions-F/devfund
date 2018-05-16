package org.minions.devfund.lourdes.battleship;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShipTest {

    @Test
    public void testOkToPlaceShipAt() {
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        assertTrue(submarine.okToPlaceShipAt(0, 1, false, ocean));
    }

    @Test
    public void testOkPlaceShipAtOccupiedPlace() {
        final int row = 0;
        final int column = 1;
        final boolean horizontal = false;
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        assertFalse(submarine.okToPlaceShipAt(1, 1, false, ocean));
    }
    @Test
    public void testOkPlaceTwoHorizontalShipAtTwoOneAndThreeFour() {
        final int rowShip1 = 2;
        final int rowColumn1 = 1;
        final int rowShip2 = 3;
        final int rowColumn2 = 4;
        final boolean horizontal = true;
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        submarine.placeShipAt(rowShip1, rowColumn1, horizontal, ocean);
        assertFalse(submarine.okToPlaceShipAt(rowShip2, rowColumn2, horizontal, ocean));
    }

    @Test
    public void testPlaceShipAt00() {
        final int row = 0;
        final int column = 0;
        final boolean horizontal = false;
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        assertEquals(submarine.getShipType(),ocean.getShipArray()[0][0].getShipType());
        assertEquals(submarine.getShipType(),ocean.getShipArray()[1][0].getShipType());
        assertEquals(submarine.getShipType(),ocean.getShipArray()[2][0].getShipType());
    }

    @Test
    public void testPlaceTwoHorizontalShipAtTwoOneAndThreeFour() {
        final int rowShip1 = 2;
        final int rowColumn1 = 1;
        final int rowShip2 = 3;
        final int rowColumn2 = 4;
        final boolean horizontal = true;
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        submarine.placeShipAt(rowShip1, rowColumn1, horizontal, ocean);
        submarine.placeShipAt(rowShip2, rowColumn2, horizontal, ocean);
        assertEquals("empty",ocean.getShipArray()[3][4].getShipType());
        assertEquals("empty",ocean.getShipArray()[3][5].getShipType());
        assertEquals("empty",ocean.getShipArray()[3][6].getShipType());
    }
}