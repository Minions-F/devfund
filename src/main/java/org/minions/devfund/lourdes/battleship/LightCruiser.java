package org.minions.devfund.lourdes.battleship;

public class LightCruiser extends Ship {
    public LightCruiser() {
        lenght = 5;
        hit = new boolean[lenght];
    }

    @Override
    String getShipType() {
        return "LightCruiser";
    }
}
