package org.minions.devfund.bruno;

import org.junit.Before;
import org.junit.Test;
import org.minions.devfund.bruno.battleship.BattleShip;
import org.minions.devfund.bruno.battleship.EmptySea;
import org.minions.devfund.bruno.battleship.Ocean;
import org.minions.devfund.bruno.battleship.Ship;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link Ship}.
 */
public class ShipTest {

    private Ocean ocean;

    /**
     * Setups a new Ocean for the tests.
     */
    @Before
    public void setupOcean() {
        ocean = new Ocean();
    }

    /**
     * Test ok to place ship at by default.
     */
    @Test
    public void testOkToPlaceShipAtByDefault() {
        final int colSeventeen = 17;
        final int colTen = 10;
        final int colFifteen = 15;
        final int colTwelve = 12;
        Ship ship = new BattleShip();
        assertFalse(ship.okToPlaceShipAt(0, colSeventeen, true, ocean));
        assertTrue(ship.okToPlaceShipAt(0, colTen, true, ocean));
        assertFalse(ship.okToPlaceShipAt(colFifteen, colSeventeen, false, ocean));
        assertTrue(ship.okToPlaceShipAt(colTwelve, colTen, false, ocean));
    }

    /**
     * Test is vertical ship.
     */
    @Test
    public void testIsVertical() {
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, false, ocean);
        assertFalse(ship.isHorizontal());
        assertFalse(ship.wasShootAt(0, 0));
        assertTrue(ship.shootAt(0, 0));
        assertFalse(ship.isBowHit(0, false, 0, 0));
    }

    /**
     * Test is sunk always false.
     */
    @Test
    public void testIsSunkAlwaysFalse() {
        EmptySea ship = new EmptySea();
        assertFalse(ship.isSunk());
    }

    /**
     * Test single-character String to use in the Ocean's print method.
     */
    @Test
    public void testSingleCharacter() {
        EmptySea ship = new EmptySea();
        String characterExpected = ".";
        String characterActual = ship.toString();
        assertEquals(characterExpected, characterActual);
        assertFalse(ship.isSunk());
    }

    /**
     * Test ok to place ship at battle ship.
     */
    @Test
    public void testOkToPlaceShipAt() {
        final int colFour = 4;
        final int colTen = 10;
        final int colThirteen = 15;
        Ship ship1 = new BattleShip();
        Ship ship2 = new BattleShip();
        assertTrue(ship1.okToPlaceShipAt(0, colTen, true, ocean));
        ship1.placeShipAt(0, colTen, true, ocean);
        assertTrue(ship2.okToPlaceShipAt(1, 0, false, ocean));
        assertTrue(ship2.okToPlaceShipAt(1, 0, true, ocean));
        assertFalse(ship2.okToPlaceShipAt(1, colFour, true, ocean));
        assertFalse(ship2.okToPlaceShipAt(1, colThirteen, false, ocean));
    }

    /**
     * Test is sunk.
     */
    @Test
    public void testIsSunk() {
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        IntStream.range(0, ship.getLength()).forEachOrdered(col -> ocean.shootAt(0, col));
        assertTrue(ship.isSunk());
    }

    /**
     * Test is not sunk.
     */
    @Test
    public void testIsNotSunk() {
        BattleShip ship = new BattleShip();
        int almostShipLength = ship.getLength() - 1;
        ship.placeShipAt(0, 0, true, ocean);
        IntStream.range(0, almostShipLength).forEachOrdered(col -> ocean.shootAt(0, col));
        assertFalse(ship.isSunk());
    }

    /**
     * Test to string X.
     */
    @Test
    public void testToStringX() {
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        IntStream.range(0, ship.getLength()).forEachOrdered(col -> ocean.shootAt(0, col));
        assertEquals("x", ship.toString());

    }

    /**
     * Test to string S.
     */
    @Test
    public void testToStringS() {
        BattleShip ship = new BattleShip();
        int almostShipLength = ship.getLength() - 1;
        ship.placeShipAt(0, 0, true, ocean);
        IntStream.range(0, almostShipLength).forEachOrdered(col -> ocean.shootAt(0, col));
        assertEquals("S", ship.toString());
    }

    /**
     * Test shot At.
     */
    @Test
    public void testShootAt() {
        final int colThree = 3;
        final int colFour = 4;
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        assertTrue(ship.shootAt(0, colThree));
        assertTrue(ship.shootAt(0, colFour));
        assertFalse(ship.shootAt(1, colFour));

    }

    /**
     * Test shoot at.
     */
    @Test
    public void testShootAtColumn() {
        final int colThree = 3;
        final int colFour = 4;
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        IntStream.range(0, ship.getLength()).forEachOrdered(col -> ocean.shootAt(0, col));
        assertFalse(ship.shootAt(0, colThree));
        assertFalse(ship.shootAt(0, colFour));
        assertFalse(ship.shootAt(1, colFour));
    }

    /**
     * Test set horizontal ship.
     */
    @Test
    public void testSetHorizontal() {
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        ship.setHorizontal(false);
        assertFalse(ship.isHorizontal());
    }

    /**
     * Test get bow row.
     */
    @Test
    public void testGetBowRow() {
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        assertEquals(0, ship.getBowRow());
    }

    /**
     * Test set bow row.
     */
    @Test
    public void testSetBowRow() {
        BattleShip ship = new BattleShip();
        int bowRowExpected = 2;
        ship.setBowRow(bowRowExpected);
        assertEquals(bowRowExpected, ship.getBowRow());
    }

    /**
     * Test get bow col.
     */
    @Test
    public void testGetBowCol() {
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        assertEquals(0, ship.getBowColumn());
    }

    /**
     * Test set bow col.
     */
    @Test
    public void testSetBowCol() {
        BattleShip ship = new BattleShip();
        int bowColExpected = 2;
        ship.setBowColumn(bowColExpected);
        assertEquals(bowColExpected, ship.getBowColumn());
    }
}
