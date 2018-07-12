package org.minions.devfund.yuri.battleship;

import java.util.Arrays;

/**
 * Represents an Empty Sea.
 */
public class EmptySea extends Ship {
    /**
     * Constructor method.
     */
    public EmptySea() {
        setLength(1);
        setHit(new boolean[1]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean shootAt(final int row, final int column) {
        return false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean isSunk() {
        return false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        return "ES";
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String getShipType() {
        return "empty";
    }
}
