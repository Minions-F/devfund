package org.minions.devfund.lourdes.battleship;

public class LightCruiser extends Ship {
    public LightCruiser() {
        length = 5;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "lightcruiser";
    }
}
