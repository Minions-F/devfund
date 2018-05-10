package org.minions.devfund.sergio.battleship_game;

import java.util.Arrays;

public class Submarine extends Ship {

    public Submarine() {
        setSize(3);
        setHit(new boolean[3]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "Submarine";
    }
}
