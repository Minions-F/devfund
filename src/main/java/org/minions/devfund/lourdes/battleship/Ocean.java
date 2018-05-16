package org.minions.devfund.lourdes.battleship;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Ocean {
    private Ship[][] ship;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    public Ocean() {
        this.ship = new Ship[20][20];
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
        for (Ship[] row : ship) {
            Arrays.fill(row, new EmptySea());
        }
    }

    public boolean isOccupied(int row, int column) {
        return !ship[row][column].getShipType().equals("empty");
    }

    public boolean shootAt(int row, int column) {
        if (isOccupied(row, column) &&
                getShipArray()[row][column].toString().equals("S") &&
                getShipArray()[row][column].shootAt(row, column)) {
            hitCount++;
            if (getShipArray()[row][column].isSunk()) shipsSunk++;
            shotsFired++;
            return true;
        }
        return false;
    }

    public void print() {
        printColumnPosition();
        for (int i = 0; i < ship.length; i++) {
            System.out.println("");
            System.out.print(i);
            for (int j = 0; j < ship.length; j++) {

                System.out.print(" "+ship[i][j]+" " );
            }
            System.out.println("");
        }
        System.out.println("");

    }
    public void printColumnPosition(){
        StringBuilder arrayPosition = new StringBuilder(" ");
        for (int i = 0; i < ship.length; i++) {
            if(i<10){
                arrayPosition.append("0");
            }
            arrayPosition.append(i);
            arrayPosition.append(" ");

        }
        System.out.print(arrayPosition);
    }

    public static void main(String arg[]) {
        Ocean ocean = new Ocean();
        Ship a = new Submarine();
        a.placeShipAt(3,3, true, ocean);
        ocean.print();
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public void setShotsFired(int shotsFired) {
        this.shotsFired = shotsFired;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public int getShipsSunk() {
        return shipsSunk;
    }

    public void setShipsSunk(int shipsSunk) {
        this.shipsSunk = shipsSunk;
    }

    public boolean isGameOver() {
        return shipsSunk == 13;
    }

    public Ship[][] getShipArray() {
        return ship;
    }

}
