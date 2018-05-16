package org.minions.devfund.lourdes.battleship;

public class Cruiser extends Ship {
    public Cruiser() {
        lenght = 6;
        hit = new boolean[lenght];
    }

    @Override
    String getShipType() {
        return "Cruiser";
    }
}
