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
    public void testOkPlaceShipAtVerticalPlace() {
        final int row = 18;
        final int column = 8;
        final boolean horizontal = false;
        Ocean ocean = new Ocean();
        Ship submarine = new BattleShip();
        submarine.placeShipAt(row, column, horizontal, ocean);
        assertFalse(submarine.okToPlaceShipAt(18, 8, false, ocean));
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
    public void testPlaceShipAt170() {
        final int row = 0;
        final int column = 17;
        final boolean horizontal = true;
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        assertEquals(submarine.getLength(),3);
        assertTrue(submarine.okToPlaceShipAt(row, column, horizontal, ocean));
        submarine.placeShipAt(row, column, horizontal, ocean);
        assertEquals(submarine.getShipType(),ocean.getShipArray()[0][17].getShipType());
        assertEquals(submarine.getShipType(),ocean.getShipArray()[0][18].getShipType());
        assertEquals(submarine.getShipType(),ocean.getShipArray()[0][19].getShipType());
    }
    @Test
    public void testOkPlaceShipAt() {
        final int row = 3;
        final int column = 3;
        final boolean horizontal = true;
        Ocean ocean = new Ocean();
        Ship submarine1 = new Submarine();
        Ship submarine2 = new Submarine();

        submarine1.placeShipAt(row, column, horizontal, ocean);
        assertFalse(submarine2.okToPlaceShipAt(2, 1, horizontal, ocean));


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


    @Test
    public void testIsSunk() {
        final int row = 2;
        final int column = 1;
        final boolean horizontal = false;
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        submarine.shootAt(row,column);
        submarine.shootAt(3,column);
        submarine.shootAt(4,column);
        assertTrue(submarine.isSunk());
    }
    @Test
    public void testIsNotSunk() {
        final int row = 2;
        final int column = 1;
        final boolean horizontal = true;
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        submarine.placeShipAt(row, column, horizontal, ocean);
        submarine.shootAt(row,column);
        submarine.shootAt(row,2);
        assertFalse(submarine.isSunk());
    }
}