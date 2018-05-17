package org.minions.devfund.lourdes.battleship;

public class Destroyer extends Ship {
    public Destroyer(){
        length = 4;
        hit = new boolean[length];
    }
    @Override
    String getShipType() {
        return "destroyer";
    }
}
