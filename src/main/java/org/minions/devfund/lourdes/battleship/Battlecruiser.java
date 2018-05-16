package org.minions.devfund.lourdes.battleship;

public class Battlecruiser extends Ship {
    public Battlecruiser() {
        lenght = 7;
        hit = new boolean[lenght];
    }

    @Override
    String getShipType() {
        return "BattleCruiser";
    }
}
