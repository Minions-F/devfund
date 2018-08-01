package org.minions.devfund.lourdes.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Implemented tests for {@link BattleCruiser}.
 */
public class BattleCruiserTest {
    private BattleCruiser battleCruiser;

    /**
     * Method that setup initial values.
     */
    @Before
    public void setup() {
        battleCruiser = new BattleCruiser();
    }

    /**
     * Verify BattleCruiser constructor.
     */
    @Test
    public void testBattleCruiserInitialization() {
        final int expectedLenght = 7;
        final boolean[] expectedHit = new boolean[expectedLenght];
        assertEquals(expectedLenght, battleCruiser.length);
        assertArrayEquals(expectedHit, battleCruiser.hit);
    }

    /**
     * Verify BattleCruiser ship type.
     */
    @Test
    public void getShipType() {
        final String expType = "battlecruiser";
        assertEquals(expType, battleCruiser.getShipType());
    }
}
