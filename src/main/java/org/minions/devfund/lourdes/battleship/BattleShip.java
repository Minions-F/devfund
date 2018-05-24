package org.minions.devfund.lourdes.battleship;

/**
 * Class that define the Battleship ship.
 */
class BattleShip extends Ship {
    /**
     * Constructor.
     */
     BattleShip() {
        length = 8;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "battleship";
    }
}
