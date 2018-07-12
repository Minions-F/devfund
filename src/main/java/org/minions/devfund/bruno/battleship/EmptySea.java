package org.minions.devfund.bruno.battleship;

import java.util.Arrays;

/**
 * The Ocean contains a Ship array, every location of which is, or can be, a reference to some Ship.
 */
public class EmptySea extends Ship {

    private static final int LENGTH = 1;

    /**
     * Constructor to the destroyer ship sets the inherited length variable to 1.
     */
    public EmptySea() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return "empty";
    }

    /**
     * This method overrides shootAt(int row, int column) that is inherited from Ship,
     * and always returns false to indicate that nothing was hit.
     */
    @Override
    public boolean shootAt(int row, int column) {
        this.getHit()[0] = true;
        return false;
    }

    /**
     * Returns always false to indicate that you did not sink anything.
     */
    @Override
    public boolean isSunk() {
        return false;
    }

    /**
     * Returns a single-character String to use in the Ocean's print method.
     */
    @Override
    public String toString() {
        return this.getHit()[0] ? "-" : ".";
    }
}
