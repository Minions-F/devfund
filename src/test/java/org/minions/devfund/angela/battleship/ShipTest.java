package org.minions.devfund.angela.battleship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Ship}.
 */
public class ShipTest {

    private Ship ship;

    /**
     * Verifies if is printing.
     */
    @Test
    public void testSubmarine() {
        ship = new Submarine();
        final int submarineLength = 3;
        assertEquals(submarineLength, ship.getLength());
    }
}
