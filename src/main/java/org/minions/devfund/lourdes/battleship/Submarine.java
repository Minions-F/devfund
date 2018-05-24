package org.minions.devfund.lourdes.battleship;

/**
 * Class that defines the Submarine Ship.
 */
class Submarine extends Ship {
    /**
     * Constructor.
     */
    Submarine(){
        length = 3;
        hit = new boolean[length];
    }
    @Override
    String getShipType() {
        return "submarine";
    }
}
