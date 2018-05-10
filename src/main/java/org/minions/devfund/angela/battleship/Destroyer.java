package org.minions.devfund.angela.battleship;

import java.util.Arrays;

/**
 * {@inheritDoc}.
 */
public class Destroyer extends Ship {

    /**
     * Initializes an instance of {@link Destroyer}.
     */
    public Destroyer() {
        final int shipLength = 4;
        setLength(shipLength);
        setHit(new Boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    String getShipType() {
        return "destroyer";
    }
}
