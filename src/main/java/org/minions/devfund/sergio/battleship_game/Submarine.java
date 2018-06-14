package org.minions.devfund.sergio.battleship_game;

import java.util.Arrays;

public class Submarine extends Ship {

    public Submarine() {

        setSize(3);
        Arrays.fill(getHit(), false);
    }

    @Override
    public String getShipType() {
        return "Submarine";
    }
}
