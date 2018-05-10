package org.minions.devfund.sergio.battleship_game;

import java.util.Arrays;

public class Destroyer extends Ship {
    public Destroyer() {
        setSize(6);
        setHit(new boolean[6]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "Destroyer";
    }
}
