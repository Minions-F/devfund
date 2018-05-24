package org.minions.devfund.lourdes.battleship;

/**
 * Class that define the Destroyer ship.
 */
class Destroyer extends Ship {
    /**
     * Constructor.
     */
    Destroyer(){
        length = 4;
        hit = new boolean[length];
    }
    @Override
    String getShipType() {
        return "destroyer";
    }
}
