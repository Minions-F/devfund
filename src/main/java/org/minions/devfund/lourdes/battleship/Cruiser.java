package org.minions.devfund.lourdes.battleship;

/**
 * Class that defines the Cruiser ship.
 */
class Cruiser extends Ship {
    private static final int SIZE_CRUISER = 6;
    /**
     * Constructor.
     */
    Cruiser() {
        length = SIZE_CRUISER;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "cruiser";
    }
}
