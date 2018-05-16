package org.minions.devfund.lourdes.battleship;

public class Submarine extends Ship {

    public Submarine(){
        lenght = 3;
        hit = new boolean[lenght];
    }
    @Override
    String getShipType() {
        return "Submarine";
    }
}
