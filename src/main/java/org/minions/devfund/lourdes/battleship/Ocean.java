package org.minions.devfund.lourdes.battleship;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Ocean {
    private static final Map<String, Integer> SHIP_TYPE = new HashMap<>();

    static {
        SHIP_TYPE.put("BattleShip", 1);
        SHIP_TYPE.put("BattleCruiser", 1);
        SHIP_TYPE.put("Cruiser", 2);
        SHIP_TYPE.put("LightCruiser", 2);
        SHIP_TYPE.put("Destroyer", 3);
        SHIP_TYPE.put("Submarine", 4);
    }

    private Ship[][] ship;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    public Ocean() {
        this.ship = new Ship[20][20];
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
        for (int i = 0; i < ship.length; i++) {
            for (int j = 0; j < ship.length; j++) {
                EmptySea emptySea = new EmptySea();
                emptySea.placeShipAt(i, j, true, this);
            }
        }
    }

    public void placeAllShipsRandomly() {
        ShipFactory shipFactory = new ShipFactory();
        SHIP_TYPE.forEach((key, value) -> {
            positionShip(key, value, shipFactory);

        });
    }

    public void positionShip(String shipType, Integer shipQuantity, ShipFactory shipFactory) {
        Random r = new Random();
        for (int i = 0; i < shipQuantity; i++) {
            boolean var = false;
            while (!var) {
                int row = r.nextInt(ship.length - 1);
                int column = r.nextInt(ship.length - 1);
                boolean horizontal = r.nextBoolean();
                Ship newShip = shipFactory.createShip(shipType);
                if (newShip.okToPlaceShipAt(row, column, horizontal, this)) {
                    newShip.placeShipAt(row, column, horizontal, this);
                    var = true;
                }
            }


        }
    }


    public boolean isOccupied(int row, int column) {
        return ship[row][column] != null && !ship[row][column].getShipType().equals("empty");
    }

    public boolean shootAt(int row, int column) {
        boolean sunk = getShipArray()[row][column].isSunk();
        shotsFired++;
        getShipArray()[row][column].shootAt(row, column);

        if (isOccupied(row, column) && !getShipArray()[row][column].shootAt(row, column)) {
            hitCount++;
            if (getShipArray()[row][column].isSunk()){
                shipsSunk += (getShipArray()[row][column].isSunk() != sunk)?1:0;

            } else {
                return true;
            }
        }

        return false;
    }

    public void print() {
        printColumnPosition();
        for (int i = 0; i < ship.length; i++) {
            System.out.println("");
            System.out.print(i);
            for (int j = 0; j < ship.length; j++) {
                if (ship[i][j].toString().equals("S") && !ship[i][j].hit[ship[i][j].getHitIndex(i, j)]) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" " + ship[i][j] + " ");

                }

            }
            System.out.println("");
        }
        System.out.println("");

    }

    public void printColumnPosition() {
        StringBuilder arrayPosition = new StringBuilder(" ");
        for (int i = 0; i < ship.length; i++) {
            if (i < 10) {
                arrayPosition.append("0");
            }
            arrayPosition.append(i);
            arrayPosition.append(" ");

        }
        System.out.print(arrayPosition);
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
