package org.minions.devfund.lourdes.battleship;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * Class that define Ocean entity.
 */
public class Ocean {
    private static final int TOTAL_CRUISER = 2;
    private static final int TOTAL_DESTROYER = 3;
    private static final int TOTAL_SUBMARINE = 4;
    private static final int TOTAL_SHIPS = 13;
    private static final Map<String, Integer> SHIP_TYPE = new LinkedHashMap<>();

    static {
        SHIP_TYPE.put("BattleShip", 1);
        SHIP_TYPE.put("BattleCruiser", 1);
        SHIP_TYPE.put("Cruiser", TOTAL_CRUISER);
        SHIP_TYPE.put("LightCruiser", TOTAL_CRUISER);
        SHIP_TYPE.put("Destroyer", TOTAL_DESTROYER);
        SHIP_TYPE.put("Submarine", TOTAL_SUBMARINE);
    }

    private static final int SIZE_SHIP = 20;

    private Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    /**
     * Constructor.
     */
    Ocean() {
        this.ships = new Ship[SIZE_SHIP][SIZE_SHIP];
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships.length; j++) {
                EmptySea emptySea = new EmptySea();
                emptySea.placeShipAt(i, j, true, this);
            }
        }
    }

    /**
     * Method that place randomly all ships in the ocean.
     */
    void placeAllShipsRandomly() {
        ShipFactory shipFactory = new ShipFactory();
        SHIP_TYPE.forEach((key, value) -> positionShip(key, value, shipFactory));
    }

    /**
     * Method that position a ship in the ocean.
     *
     * @param shipType     represents the ship type.
     * @param shipQuantity represents the ship quantity.
     * @param shipFactory  ship factory.
     */
    private void positionShip(final String shipType, final Integer shipQuantity, final ShipFactory shipFactory) {
        Random random = new Random();
        for (int i = 0; i < shipQuantity; i++) {
            boolean placeShip = false;
            while (!placeShip) {
                int row = random.nextInt(ships.length - 1);
                int column = random.nextInt(ships.length - 1);
                boolean horizontal = random.nextBoolean();
                Ship newShip = shipFactory.createShip(shipType);
                if (newShip.okToPlaceShipAt(row, column, horizontal, this)) {
                    newShip.placeShipAt(row, column, horizontal, this);
                    placeShip = true;
                }
            }
        }
    }

    /**
     * Method that verify if a position is occupied.
     *
     * @param row    row position.
     * @param column column position.
     * @return True if the given position is occupied, false otherwise.
     */
    boolean isOccupied(int row, int column) {
        return !(ships[row][column] instanceof EmptySea);
    }

    /**
     * Method that shoot in a position.
     *
     * @param row    row position.
     * @param column column position.
     * @return True if the shoot was accurate, False otherwise.
     */
    boolean shootAt(int row, int column) {
        shotsFired++;
        if (isOccupied(row, column) && !ships[row][column].isSunk()) {
            hitCount++;
            if (ships[row][column].shootAt(row, column)) {
                if (ships[row][column].isSunk()) {
                    shipsSunk++;
                }
                return true;
            }
            return false;
        }
        ships[row][column].shootAt(row, column);
        return false;
    }

    /**
     * Method that print the ocean.
     *
     * @return a String with the representation of the ocean.
     */
    public String print() {
        StringBuilder printOcean = new StringBuilder();
        printOcean.append(printColumnPosition());
        for (int i = 0; i < ships.length; i++) {
            printOcean.append("\n");
            printOcean.append(i);
            for (int j = 0; j < ships.length; j++) {
                if (ships[i][j].toString().equals("S") && !ships[i][j].hit[ships[i][j].getHitIndex(i, j)]) {
                    printOcean.append(" . ");
                } else {
                    printOcean.append(String.format(" %s ", ships[i][j]));
                }
            }
        }
        return printOcean.toString();
    }

    /**
     * Method tha print column numbers in the ocean.
     *
     * @return a string with the column numbers.
     */
    private String printColumnPosition() {
        final int maxNumberAddCero = 10;
        StringBuilder arrayPosition = new StringBuilder(" ");
        for (int i = 0; i < ships.length; i++) {
            if (i < maxNumberAddCero) {
                arrayPosition.append("0");
            }
            arrayPosition.append(i);
            arrayPosition.append(" ");

        }
        return arrayPosition.toString();
    }

    /**
     * Method that return shots fired.
     *
     * @return shot fires.
     */
    public int getShotsFired() {
        return shotsFired;
    }

    /**
     * method that set shots fired.
     *
     * @param shotsFired shot fired.
     */
    public void setShotsFired(int shotsFired) {
        this.shotsFired = shotsFired;
    }

    /**
     * Method that return the hit counts.
     *
     * @return the total hit count.
     */
    public int getHitCount() {
        return hitCount;
    }

    /**
     * Method that set hit count.
     *
     * @param hitCount hit count.
     */
    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    /**
     * Method that return ships sunk.
     *
     * @return the total of ships sunk.
     */
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * Method that set the ships sunk.
     *
     * @param shipsSunk ships sunk.
     */
    public void setShipsSunk(int shipsSunk) {
        this.shipsSunk = shipsSunk;
    }

    /**
     * Method verify if the gave is over.
     *
     * @return True if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return shipsSunk == TOTAL_SHIPS;
    }

    /**
     * Method that return the ship Array.
     *
     * @return ship.
     */
    public Ship[][] getShipArray() {
        return ships.clone();
    }

}
