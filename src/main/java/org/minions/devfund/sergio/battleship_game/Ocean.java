package org.minions.devfund.sergio.battleship_game;

import java.util.Random;

public class Ocean {

    private int shots = 0;
    private int hitCount = 0;
    private int sunkShips = 0;

    public Ocean() {

    }

    public void placeAllShipsRandomly() {

        Random random = new Random();
        Ship[] ships = new Ship[13];
    }

    public boolean isFull(int row, int column) {
        return true;
    }

    public boolean shootAt(int row, int column) {
        this.shots++;
        return false;
    }

//    public Ship[][] getShipArray() {
//        return ships;
//    }
//
//    public void setShips(Ship[][] ships) {
//        this.ships = ships;
//    }

    public int getShots() {
        return shots;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getSunkShips() {
        return sunkShips;
    }

    public boolean isGameOver() {
        return sunkShips == 13;
    }
}
