package org.minions.devfund.lourdes.battleship;

public class Submarine extends Ship {

    public Submarine(){
        length = 3;
        hit = new boolean[length];
    }
    @Override
    String getShipType() {
        return "submarine";
    }
}
