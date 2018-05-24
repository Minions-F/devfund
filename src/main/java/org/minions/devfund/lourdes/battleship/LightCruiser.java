package org.minions.devfund.lourdes.battleship;

/**
 * Class that defines the Light Cruiser ship.
 */
class LightCruiser extends Ship {
    /**
     * Constructor.
     */
    LightCruiser() {
        length = 5;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "lightcruiser";
    }
}
