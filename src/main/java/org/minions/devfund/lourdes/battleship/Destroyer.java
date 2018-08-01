package org.minions.devfund.lourdes.battleship;

/**
 * Class that define the Destroyer ship.
 */
class Destroyer extends Ship {
    private static final int SIZE_DESTROYER = 4;

    /**
     * Constructor.
     */
    Destroyer() {
        length = SIZE_DESTROYER;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "destroyer";
    }
}
