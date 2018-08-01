package org.minions.devfund.lourdes.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Implemented tests for {@link BattleShip}.
 */
public class BattleShipTest {
    private BattleShip battleShip;

    /**
     * Method that setup initial values.
     */
    @Before
    public void setup() {
        battleShip = new BattleShip();
    }

    /**
     * Verify BattleShip constructor.
     */
    @Test
    public void testBattleShipInitialization() {
        final int expectedLenght = 8;
        final boolean[] expectedHit = new boolean[expectedLenght];
        assertEquals(expectedLenght, battleShip.length);
        assertArrayEquals(expectedHit, battleShip.hit);
    }

    /**
     * Verify BattleShip type.
     */
    @Test
    public void getShipType() {
        final String expType = "battleship";
        assertEquals(expType, battleShip.getShipType());
    }
}
