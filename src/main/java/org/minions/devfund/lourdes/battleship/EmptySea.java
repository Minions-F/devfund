package org.minions.devfund.lourdes.battleship;

public class EmptySea extends Ship {


    public EmptySea() {
        lenght = 1;
        hit = new boolean[lenght];
    }

    @Override
    public boolean shootAt(int row, int column) {
        super.shootAt(row, column);
        return false;
    }

    @Override
    public boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return getHit()[0] ? "-" : ".";
    }

    @Override
    String getShipType() {
        return "empty";
    }
}
