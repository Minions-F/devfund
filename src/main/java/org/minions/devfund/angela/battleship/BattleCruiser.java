package org.minions.devfund.angela.battleship;

import java.util.Arrays;

/**
 * {@inheritDoc}.
 */
public class BattleCruiser extends Ship {

    /**
     * Initializes an instance of {@link BattleCruiser}.
     */
    public BattleCruiser() {
        final int shipLength = 7;
        setLength(shipLength);
        setHit(new Boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     *
     * @return
     */
    @Override
    String getShipType() {
        return "battlecruiser";
    }
}
