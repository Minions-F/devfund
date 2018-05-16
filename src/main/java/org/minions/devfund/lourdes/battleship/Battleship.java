package org.minions.devfund.lourdes.battleship;

public class Battleship extends Ship {
    public Battleship() {
        lenght = 8;
        hit = new boolean[lenght];
    }

    @Override
    String getShipType() {
        return "Battleship";
    }
}
