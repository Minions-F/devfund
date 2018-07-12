package org.minions.devfund.yuri.battleship;

import java.util.Arrays;

/**
 * Represents to BattleCruiser.
 */
public class BattleCruiser extends Ship {

    public static final int SQUARES = 7;

    /**
     * Constructor method.
     */
    public BattleCruiser() {
        setLength(SQUARES);
        setHit(new boolean[SQUARES]);
        Arrays.fill(getHit(), false);
    }
    /**
     * {@inheritDoc}.
     */
    @Override
    public String getShipType() {
        return "BattleCruiser";
    }
}
