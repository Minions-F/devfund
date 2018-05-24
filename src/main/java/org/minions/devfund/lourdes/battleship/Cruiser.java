package org.minions.devfund.lourdes.battleship;

/**
 * Class that defines the Cruiser ship.
 */
class Cruiser extends Ship {
    /**
     * Constructor.
     */
    Cruiser() {
        length = 6;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "cruiser";
    }
}
