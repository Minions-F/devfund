package org.minions.devfund.lourdes.battleship;

/**
 * Class that defines the Submarine Ship.
 */
class Submarine extends Ship {
    private static final int SIZE_SUBMARINE = 3;

    /**
     * Constructor.
     */
    Submarine() {
        length = SIZE_SUBMARINE;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "submarine";
    }
}
