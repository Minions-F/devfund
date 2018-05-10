package org.minions.devfund.angela.battleship;

import java.util.Arrays;

/**
 * {@inheritDoc}.
 */
public class Cruiser extends Ship {

    /**
     * Initializes an instance of {@link Cruiser}.
     */
    public Cruiser() {
        final int shipLength = 6;
        setLength(shipLength);
        setHit(new Boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    String getShipType() {
        return "cruiser";
    }
}
