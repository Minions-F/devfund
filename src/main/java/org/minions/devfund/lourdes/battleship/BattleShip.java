package org.minions.devfund.lourdes.battleship;

/**
 * Class that define the Battleship ship.
 */
class BattleShip extends Ship {
    private static final int SIZE_BATTLE_SHIP = 8;
    /**
     * Constructor.
     */
     BattleShip() {
        length = SIZE_BATTLE_SHIP;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "battleship";
    }
}
