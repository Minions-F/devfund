package org.minions.devfund.sergio.battleship_game;

import java.util.Arrays;

public class BattleCruiser extends Ship {

    public BattleCruiser() {
        setSize(7);
        setHit(new boolean[7]);
        Arrays.fill(getHit(), false);
    }

    @Override
    public String getShipType() {
        return "Battlecruiser";
    }
}
