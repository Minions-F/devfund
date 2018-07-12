package org.minions.devfund.bruno.battleship;

import java.util.Arrays;

/**
 * Class that represent to the submarine ship.
 */
public class Submarine extends Ship {

    private static final int LENGTH = 3;

    /**
     * Constructor to the submarine ship sets the inherited length variable to 3.
     */
    public Submarine() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return "submarine";
    }
}
