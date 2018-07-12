package org.minions.devfund.bruno.battleship;

import java.util.Arrays;

/**
 * Class that represent to the light cruiser.
 */
public class LightCruiser extends Ship {

    private static final int LENGTH = 5;

    /**
     * Constructor to the light cruiser sets the inherited length variable to 5.
     */
    public LightCruiser() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return "light cruiser";
    }
}
