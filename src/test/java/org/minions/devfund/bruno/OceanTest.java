package org.minions.devfund.bruno;


import org.junit.Before;
import org.junit.Test;
import org.minions.devfund.bruno.battleship.BattleShip;
import org.minions.devfund.bruno.battleship.Ocean;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link Ocean}.
 */
public class OceanTest {

    private static final int OCEAN_SIZE = 20;
    private Ocean ocean;

    /**
     * Setups a new Ocean for the tests.
     */
    @Before
    public void setupOcean() {
        ocean = new Ocean();
    }

    /**
     * Test to Ocean Constructor.
     */
    @Test
    public void testOceanConstructor() {
        String emptyValueExpected = "empty";
        int zeroValueExpected = 0;
        assertEquals(zeroValueExpected, ocean.getHitCount());
        assertEquals(zeroValueExpected, ocean.getShipsSunk());
        assertEquals(zeroValueExpected, ocean.getShotsFired());
        range(0, OCEAN_SIZE).forEach(row ->
                range(0, OCEAN_SIZE).forEach(col ->
                        assertEquals(emptyValueExpected, ocean.getShipArray()[row][col].getShipType())));
    }

    /**
     * Test place all ships randomly.
     */
    @Test
    public void testPlaceAllShipsRandomly() {
        final int shipCountExpected = 61;
        String emptyValueExpected = "empty";
        int zeroValueExpected = 0;
        ocean.placeAllShipsRandomly();
        assertEquals(zeroValueExpected, ocean.getHitCount());
        assertEquals(zeroValueExpected, ocean.getShipsSunk());
        assertEquals(zeroValueExpected, ocean.getShotsFired());
        int shipCountActual = range(0, OCEAN_SIZE).map(row -> Math.toIntExact(range(0, OCEAN_SIZE).filter(col ->
                !ocean.getShipArray()[row][col].getShipType().equals(emptyValueExpected)).count())).sum();
        assertEquals(shipCountExpected, shipCountActual);
    }

    /**
     * Test is place occupied.
     */
    @Test
    public void testIsOccupied() {
        range(0, OCEAN_SIZE).forEach(row ->
                range(0, OCEAN_SIZE).forEach(col -> assertFalse(ocean.isOccupied(row, col))));
    }

    /**
     * Test is place occupied on the column ship.
     */
    @Test
    public void testIsOccupiedOnTheColumnShip() {
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        range(0, ship.getLength()).forEach(col -> assertTrue(ocean.isOccupied(0, col)));
        assertFalse(ocean.isOccupied(0, ship.getLength()));
    }

    /**
     * Test shoot ship and hit count.
     */
    @Test
    public void testShootAtHitCount() {
        final int hitCountExpected = 2;
        final int shipsSunkExpected = 0;
        final int shotsFiredExpected = 3;
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        ocean.shootAt(0, 0);
        ocean.shootAt(0, 0);
        ocean.shootAt(1, 0);
        assertEquals(hitCountExpected, ocean.getHitCount());
        assertEquals(shipsSunkExpected, ocean.getShipsSunk());
        assertEquals(shotsFiredExpected, ocean.getShotsFired());
    }

    /**
     * Test shoot and sunk ship.
     */
    @Test
    public void testShootAndSunkShip() {
        final int hitCountExpected = 8;
        final int shipsSunkExpected = 1;
        final int shotsFiredExpected = 10;
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        IntStream.range(0, ship.getLength()).forEachOrdered(col -> ocean.shootAt(0, col));
        ocean.shootAt(0, 1);
        ocean.shootAt(0, 2);
        assertEquals(hitCountExpected, ocean.getHitCount());
        assertEquals(shipsSunkExpected, ocean.getShipsSunk());
        assertEquals(shotsFiredExpected, ocean.getShotsFired());
    }

    /**
     * Test place to string.
     */
    @Test
    public void testToString() {
        final int hitCountExpected = 8;
        final int shipsSunkExpected = 1;
        final int shotsFiredExpected = 8;
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        IntStream.range(0, ship.getLength()).forEachOrdered(col -> ocean.shootAt(0, col));
        assertEquals(hitCountExpected, ocean.getHitCount());
        assertEquals(shipsSunkExpected, ocean.getShipsSunk());
        assertEquals(shotsFiredExpected, ocean.getShotsFired());
        StringBuilder area = new StringBuilder();
        area.append(" ");
        IntStream.range(0, OCEAN_SIZE).mapToObj(row -> String.format("%3d", row)).forEach(area::append);
        area.append("\n");
        range(0, OCEAN_SIZE).forEach(row -> {
            area.append(String.format("%2d ", row));
            range(0, OCEAN_SIZE).forEach(col ->
                    area.append(row == 0 && col < ship.getLength() ? "x  " : ".  "));
            area.append("\n");
        });
        assertEquals(area.toString(), ocean.print());
    }

    /**
     * Test to string almost length.
     */
    @Test
    public void testToStringAlmostLength() {
        final int hitCountExpected = 7;
        final int shipsSunkExpected = 0;
        final int shotsFiredExpected = 7;
        final int almostShipLength = 7;
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        IntStream.range(0, almostShipLength).forEachOrdered(col -> ocean.shootAt(0, col));
        assertEquals(hitCountExpected, ocean.getHitCount());
        assertEquals(shipsSunkExpected, ocean.getShipsSunk());
        assertEquals(shotsFiredExpected, ocean.getShotsFired());
        StringBuilder area = new StringBuilder();
        area.append(" ");
        IntStream.range(0, OCEAN_SIZE).mapToObj(i -> String.format("%3d", i)).forEachOrdered(area::append);
        area.append("\n");
        range(0, OCEAN_SIZE).forEach(row -> {
            area.append(String.format("%2d ", row));
            range(0, OCEAN_SIZE).forEach(col ->
                    area.append(row == 0 && col < almostShipLength ? "S  " : ".  "));
            area.append("\n");
        });
        assertEquals(area.toString(), ocean.toString());
    }

    /**
     * Testis game over.
     */
    @Test
    public void testIsGameOver() {
        final int hitCountExpected = 2;
        final int shipsSunkExpected = 0;
        final int shotsFiredExpected = 3;
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        ocean.shootAt(0, 0);
        ocean.shootAt(0, 0);
        ocean.shootAt(1, 0);
        assertEquals(hitCountExpected, ocean.getHitCount());
        assertEquals(shipsSunkExpected, ocean.getShipsSunk());
        assertEquals(shotsFiredExpected, ocean.getShotsFired());
        assertFalse(ocean.isGameOver());
    }
}
