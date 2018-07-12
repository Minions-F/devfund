package org.minions.devfund.bruno;

import org.junit.Before;
import org.junit.Test;
import org.minions.devfund.bruno.battleship.BattleShip;
import org.minions.devfund.bruno.battleship.Ship;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link BattleShip}.
 */
public class BattleShipTest {

    private Ship ship;

    /**
     * Setups a new Battle Ship for the tests.
     */
    @Before
    public void setupBattleShip() {
        ship = new BattleShip();
    }

    /**
     * Test to getting the ship type.
     */
    @Test
    public void testGetShipType() {
        String shipTypeExpected = "battleship";
        String shipTypeActual = ship.getShipType();
        assertEquals(shipTypeExpected, shipTypeActual);
    }

    /**
     * Test to getting the ship length.
     */
    @Test
    public void testGetShipLength() {
        final int lengthExpected = 8;
        int lengthActual = ship.getLength();
        assertEquals(lengthExpected, lengthActual);
    }
}
