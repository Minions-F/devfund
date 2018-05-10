package org.minions.devfund.angela.battleship;

import java.util.Arrays;

/**
 * {@inheritDoc}.
 */
public class LightCruiser extends Ship {

    /**
     * Initializes an instance of {@link LightCruiser}.
     */
    public LightCruiser() {
        final int shipLength = 5;
        setLength(shipLength);
        setHit(new Boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    String getShipType() {
        return "light cruiser";
    }
}
