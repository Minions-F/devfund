package org.minions.devfund.marcos.battleship;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * It is in charged to define the unit tests for {@link Ship} class.
 */
public class ShipTest {


    /**
     * Ship ToString for a not sunk ship test.
     */
    @Test
    public void testShipToStringNotSunk() {
        final String expectedToString = "S";
        final Ship ship = new Submarine();
        assertEquals(expectedToString, ship.toString());
    }

    /**
     * Ship ToString for a sunk ship test.
     */
    @Test
    public void testShipToStringSunk() {
        final int row = 0;
        final int column = 0;
        final int columnSubmarineZero = 0;
        final int columnSubmarineOne = 1;
        final int columnSubmarineTwo = 2;
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        final String expectedToString = "x";
        ship.placeShipAt(row, column, true, ocean);
        ocean.shootAt(row, columnSubmarineZero);
        ocean.shootAt(row, columnSubmarineOne);
        ocean.shootAt(row, columnSubmarineTwo);
        assertEquals(expectedToString, ship.toString());
    }

    /**
     * Ship is horizontal for a not sunk ship test.
     */
    @Test
    public void testShipIsHorizontal() {
        final int row = 0;
        final int column = 0;
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        final boolean expectedHorizontalValue = true;
        ship.placeShipAt(row, column, true, ocean);
        assertEquals(expectedHorizontalValue, ship.isHorizontal());
    }

    /**
     * Ship set horizontal value test.
     */
    @Test
    public void testShipSetHorizontal() {
        final int row = 0;
        final int column = 0;
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        final boolean expectedHorizontalValue = false;
        ship.placeShipAt(row, column, true, ocean);
        ship.setHorizontal(false);
        assertEquals(expectedHorizontalValue, ship.isHorizontal());
    }

    /**
     * Shoot at empty place for a not sunk ship test.
     */
    @Test
    public void testShootAtEmptyPlace() {
        final int row = 0;
        final int column = 0;
        final int rowLimit = 19;
        final int columnLimit = 19;
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        ship.placeShipAt(row, column, true, ocean);
        assertFalse(ship.shootAt(rowLimit, columnLimit));
    }

    /**
     * Shoot at empty place for a not sunk ship test.
     */
    @Test
    public void testShootAfterSunk() {
        final int row = 0;
        final int column = 0;
        final int columnSubmarineZero = 0;
        final int columnSubmarineOne = 1;
        final int columnSubmarineTwo = 2;
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        ship.placeShipAt(row, column, true, ocean);
        ship.shootAt(row, columnSubmarineZero);
        ship.shootAt(row, columnSubmarineOne);
        ship.shootAt(row, columnSubmarineTwo);
        ship.shootAt(row, columnSubmarineZero);
        assertTrue(ship.isSunk());
    }

    /**
     * Set ship head with custom position test.
     */
    @Test
    public void testSetShipHead() {
        final int row = 0;
        final int column = 0;
        final int expectedRow = 0;
        final int expectedColumn = 0;
        final Ship ship = new Submarine();
        ship.setBowRow(row);
        ship.setBowColumn(column);
        assertEquals(expectedRow, ship.getBowRow());
        assertEquals(expectedColumn, ship.getBowColumn());
    }

    /**
     * Get hits array for a new Ship object.
     */
    @Test
    public void testGetHits() {
        final boolean defaultHitStatus = false;
        final Ship ship = new Submarine();
        final boolean[] expectedHits = {defaultHitStatus, defaultHitStatus, defaultHitStatus};
        assertArrayEquals(expectedHits, ship.getHit());
    }

    /**
     * Empty sea not hit toString test.
     */
    @Test
    public void testEmptySeaToStringNotFired() {
        final String expectedToStringValue = ".";
        final EmptySea ship = new EmptySea();
        assertEquals(expectedToStringValue, ship.toString());
    }

    /**
     * Empty sea hit toString test.
     */
    @Test
    public void testEmptySeaToStringFired() {
        final int row = 0;
        final int column = 0;
        final String expectedToStringValue = "-";
        final EmptySea ship = new EmptySea();
        ship.shootAt(row, column);
        assertEquals(expectedToStringValue, ship.toString());
    }

    /**
     * Empty sea get ship type test.
     */
    @Test
    public void testEmptySeaGetShipType() {
        final String expectedShipType = "empty";
        final EmptySea ship = new EmptySea();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Empty sea is sunk test.
     */
    @Test
    public void testEmptySeaIsSunk() {
        final EmptySea ship = new EmptySea();
        assertFalse(ship.isSunk());
    }

    /**
     * Battleship get ship type test.
     */
    @Test
    public void testBattleshipGetShipType() {
        final String expectedShipType = "battleship";
        final Ship ship = new BattleShip();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Battle Cruiser get ship type test.
     */
    @Test
    public void testBattleCruiserGetShipType() {
        final String expectedShipType = "battlecruiser";
        final Ship ship = new BattleCruiser();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Cruiser get ship type test.
     */
    @Test
    public void testCruiserGetShipType() {
        final String expectedShipType = "cruiser";
        final Ship ship = new Cruiser();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Destroyer get ship type test.
     */
    @Test
    public void testDestroyerGetShipType() {
        final String expectedShipType = "destroyer";
        final Ship ship = new Destroyer();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Light Cruiser get ship type test.
     */
    @Test
    public void testLightCruiserGetShipType() {
        final String expectedShipType = "light cruiser";
        final Ship ship = new LightCruiser();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Submarine get ship type test.
     */
    @Test
    public void testSubmarineGetShipType() {
        final String expectedShipType = "submarine";
        final Ship ship = new Submarine();
        assertEquals(expectedShipType, ship.getShipType());
    }
}
