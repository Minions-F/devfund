package org.minions.devfund.bruno.battleship;

import java.util.Arrays;

/**
 * Class that represent to the destroyer ship.
 */
public class Destroyer extends Ship {

    private static final int LENGTH = 4;

    /**
     * Constructor to the destroyer ship.
     */
    public Destroyer() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return "destroyer";
    }
}
