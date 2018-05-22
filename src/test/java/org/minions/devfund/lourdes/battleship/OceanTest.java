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
        for (int i = 0; i < submarine.length; i++) {
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

    @Test
    public void testShootAt() {
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        submarine.placeShipAt(3, 2, true, ocean);
        assertTrue(ocean.shootAt(3,3));
    }
    @Test
    public void testShootAtOcean() {
        Ocean ocean = new Ocean();
        Ship submarine = new BattleCruiser();
        submarine.placeShipAt(3, 2, true, ocean);
        assertTrue(ocean.shootAt(3,3));
    }

    @Test
    public void testShootAtOcean2() {
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        Ship submarine2 = new Submarine();
        Ship submarine3 = new Submarine();
        submarine.placeShipAt(3, 2, true, ocean);
        submarine2.placeShipAt(5, 2, false, ocean);
        submarine3.placeShipAt(12, 2, false, ocean);
        ocean.shootAt(5,2);
        ocean.shootAt(6,2);
        ocean.shootAt(6,2);
        ocean.shootAt(0,0);
        ocean.shootAt(7,2);

        ocean.shootAt(5,2);


        assertTrue(ocean.shootAt(3,2));
        assertTrue(ocean.shootAt(3,3));
        assertTrue(ocean.shootAt(3,4));
        assertFalse(ocean.shootAt(3,5));
        assertFalse(ocean.shootAt(3,4));
        ocean.shootAt(0,0);
        assertEquals(ocean.getShipsSunk(), 2);
        assertFalse(ocean.isGameOver());
        assertEquals(ocean.getShotsFired(), 12);
        assertEquals(ocean.getHitCount(), 9);

    }

    @Test
    public void testShootAtEmptyPosition() {
        Ocean ocean = new Ocean();
        Ship submarine = new Submarine();
        assertTrue(submarine.getLength() == 3);
        submarine.placeShipAt(3, 2, true, ocean);
        assertFalse(ocean.shootAt(2,3));
}
}