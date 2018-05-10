package org.minions.devfund.angela.battleship;

import java.util.Arrays;

/**
 * {@inheritDoc}.
 */
public class Submarine extends Ship {

    /**
     * Initializes an instance of {@link Submarine}.
     */
    public Submarine() {
        final int shipLength = 3;
        setLength(shipLength);
        setHit(new Boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    String getShipType() {
        return "submarine";
    }
}
