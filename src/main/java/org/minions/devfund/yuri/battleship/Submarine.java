package org.minions.devfund.yuri.battleship;

import java.util.Arrays;

/**
 * Represents a submarine.
 */
public class Submarine extends Ship{

    public static final int SQUARES = 3;

    /**
     * Constructor Method.
     */
    public Submarine() {
        setLength(SQUARES);
        setHit(new boolean[SQUARES]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String getShipType() {
        return "SubMarine";
    }
}
