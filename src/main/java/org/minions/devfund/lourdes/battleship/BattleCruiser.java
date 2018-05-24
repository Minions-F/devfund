package org.minions.devfund.lourdes.battleship;

/**
 * Class to manage BattleCruiser ship.
 */
class BattleCruiser extends Ship {
    /**
     * Constructor.
     */
    BattleCruiser() {
        length = 7;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "battlecruiser";
    }
}
