package org.minions.devfund.sergio.battleship_game;

import java.util.Arrays;

public class Cruiser extends Ship {

    public Cruiser() {
        setSize(6);
        setHit(new boolean[6]);
        Arrays.fill(getHit(), false);
    }

    @Override
    public String getShipType() {
        return "Cruiser";
    }
}
