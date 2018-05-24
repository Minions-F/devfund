package org.minions.devfund.lourdes.battleship;

/**
 * Class to manage BattleCruiser ship.
 */
class BattleCruiser extends Ship {
    private static final int SIZE_BATTLE_CRUISER = 7;
    /**
     * Constructor.
     */
    BattleCruiser() {
        length = SIZE_BATTLE_CRUISER;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "battlecruiser";
    }
}
