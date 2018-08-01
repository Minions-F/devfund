package org.minions.devfund.marcos.battleship;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * It is in charged to define the unit tests for {@link Ocean} class.
 */
public class OceanTest {

    private Ocean ocean;

    /**
     * Preconditions.
     */
    @Before
    public void setup() {
        ocean = new Ocean();
    }

    /**
     * Expected counter initial values test.
     */
    @Test
    public void testGetCounterValues() {
        final int expectedCounterValue = 0;
        assertFalse(ocean.isGameOver());
        assertEquals(expectedCounterValue, ocean.getShotsFired());
        assertEquals(expectedCounterValue, ocean.getHitCount());
        assertEquals(expectedCounterValue, ocean.getShipsSunk());
    }

    /**
     * Place occupied in ocean test.
     */
    @Test
    public void testIsOccupied() {
        final int row = 0;
        final int column = 0;
        final BattleShip battleShip = new BattleShip();
        battleShip.placeShipAt(row, column, true, ocean);
        assertTrue(ocean.isOccupied(row, column));
    }

    /**
     * Shoot a place occupied by ship in ocean test.
     */
    @Test
    public void testShootAtShip() {
        final int row = 0;
        final int column = 0;
        final BattleShip battleShip = new BattleShip();
        battleShip.placeShipAt(row, column, true, ocean);
        assertTrue(ocean.shootAt(row, column));
    }

    /**
     * Shoot a place not occupied by ship in ocean test.
     */
    @Test
    public void testShootAtEmpty() {
        final int row = 0;
        final int column = 0;
        assertFalse(ocean.shootAt(row, column));
    }

    /**
     * Shoot a place not occupied by ship in ocean test.
     */
    @Test
    public void testIncreaseShootsCount() {
        final int row = 0;
        final int column = 0;
        final int expectedShootCount = 1;
        ocean.shootAt(row, column);
        assertEquals(expectedShootCount, ocean.getShotsFired());
    }

    /**
     * Shoot a place occupied by ship and asserts the hit counter value.
     */
    @Test
    public void testIncreaseHitCount() {
        final int row = 0;
        final int column = 0;
        final int expectedHitCount = 1;
        final BattleShip battleShip = new BattleShip();
        battleShip.placeShipAt(row, column, true, ocean);
        ocean.shootAt(row, column);
        assertEquals(expectedHitCount, ocean.getHitCount());
    }

    /**
     * Shoots all places of a ship in ocean and asserts the sunk counter value.
     */
    @Test
    public void testIncreaseSunkCount() {
        final int row = 0;
        final int columnSubmarineZero = 0;
        final int columnSubmarineOne = 1;
        final int columnSubmarineTwo = 2;
        final int expectedHitCount = 1;
        final Submarine submarine = new Submarine();
        submarine.placeShipAt(row, columnSubmarineZero, true, ocean);
        ocean.shootAt(row, columnSubmarineZero);
        ocean.shootAt(row, columnSubmarineOne);
        ocean.shootAt(row, columnSubmarineTwo);
        assertEquals(expectedHitCount, ocean.getShipsSunk());
    }

    /**
     * Shoot all ships in the ocean and asserts the game over value.
     */
    @Test
    public void testGameOver() {
        final int initIndex = 0;
        ocean.placeAllShipsRandomly();
        IntStream.range(initIndex, ocean.getShipArray().length).forEach(row ->
                IntStream.range(initIndex, ocean.getShipArray().length).forEach(col -> ocean.shootAt(row, col)));
        assertTrue(ocean.isGameOver());
    }
}
