package org.minions.devfund.bruno.battleship;

import java.util.Arrays;

/**
 * Class that represent to the battle crusher.
 */
public class BattleCruiser extends Ship {

    private static final int LENGTH = 7;

    /**
     * Constructor to the battle cruiser.
     */
    public BattleCruiser() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return "battlecruiser";
    }
}
