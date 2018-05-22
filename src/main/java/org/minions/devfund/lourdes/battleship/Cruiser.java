package org.minions.devfund.lourdes.battleship;

public class Cruiser extends Ship {
    public Cruiser() {
        length = 6;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "cruiser";
    }
}
