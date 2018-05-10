package org.minions.devfund.angela.battleship;

import java.util.Arrays;
/**
 * {@inheritDoc}.
 */
public class BattleShip extends Ship {

    /**
     * Initializes an instance of {@link BattleShip}.
     */
    public BattleShip() {
        final int shipLength = 8;
        setLength(shipLength);
        setHit(new Boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }
    /**
     * {@inheritDoc}.
     */
    @Override
    String getShipType() {
        return "battleship";
    }
}
