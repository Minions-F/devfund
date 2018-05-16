package org.minions.devfund.lourdes.battleship;

public class Destroyer extends Ship {
    public Destroyer(){
        lenght = 4;
        hit = new boolean[lenght];
    }
    @Override
    String getShipType() {
        return "Destroyer";
    }
}
