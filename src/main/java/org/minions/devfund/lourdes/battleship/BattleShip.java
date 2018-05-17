package org.minions.devfund.lourdes.battleship;

public class BattleShip extends Ship {
    public BattleShip() {
        length = 8;
        hit = new boolean[length];
    }

    @Override
    String getShipType() {
        return "battleship";
    }
}
