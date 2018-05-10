package org.minions.devfund.sergio.battleship_game;

import java.util.Arrays;

public class BattleShip extends Ship{

    public BattleShip() {
        setSize(8);
        setHit(new boolean[8]);
        Arrays.fill(getHit(), false);
    }

    @Override
    public String getShipType() {
        return "Battleship";
    }

}
