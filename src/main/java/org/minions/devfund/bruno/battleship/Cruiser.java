package org.minions.devfund.bruno.battleship;

import java.util.Arrays;

/**
 * class that represent to the cruiser ship.
 */
public class Cruiser extends Ship {

    private static final int LENGTH = 6;

    /**
     * Constructor to the cruiser ship.
     */
    public Cruiser() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return "cruiser";
    }
}
