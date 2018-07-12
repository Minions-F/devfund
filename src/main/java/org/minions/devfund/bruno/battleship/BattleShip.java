package org.minions.devfund.bruno.battleship;

import java.util.Arrays;

/**
 * Class that represent to the battle ship.
 */
public class BattleShip extends Ship {

    private static final int LENGTH = 8;

    /**
     * Constructor to the battle ship.
     */
    public BattleShip() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return "battleship";
    }
}
