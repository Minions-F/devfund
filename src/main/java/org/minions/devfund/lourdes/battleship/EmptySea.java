package org.minions.devfund.lourdes.battleship;

/**
 * Class that define an empty ship.
 */
public class EmptySea extends Ship {

    /**
     * Constructor.
     */
    EmptySea() {
        length = 1;
        hit = new boolean[length];
    }

    @Override
    public boolean shootAt(int row, int column) {
        super.shootAt(row, column);
        return false;
    }

    @Override
    public boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return getHit()[0] ? "-" : ".";
    }

    @Override
    String getShipType() {
        return "empty";
    }
}
