package org.minions.devfund.lourdes.battleship;

public class BattleCruiser extends Ship {
    public BattleCruiser() {
        length = 7;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "battlecruiser";
    }
}
