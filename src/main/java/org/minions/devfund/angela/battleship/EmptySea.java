package org.minions.devfund.angela.battleship;

import java.util.Arrays;

/**
 * Manages an Empty sea ship.
 */
public class EmptySea extends Ship {

    /**
     * Initializes an instance of {@link EmptySea}.
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
    boolean shootAt(int row, int column) {
        setHit(new boolean[]{true});
        return false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    boolean isSunk() {
        return false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    String getShipType() {
        return "empty";
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        return getHit()[0] ? "-" : ".";
    }
}
