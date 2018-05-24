package org.minions.devfund.lourdes.battleship;

/**
 * Class that defines the Light Cruiser ship.
 */
class LightCruiser extends Ship {
    private static final int SIZE_LIGHT_CRUISER = 5;
    /**
     * Constructor.
     */
    LightCruiser() {
        length = SIZE_LIGHT_CRUISER;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "lightcruiser";
    }
}
