package org.minions.devfund.angela.battleship;

import java.util.Random;

/**
 * Manages ship's ocean.
 */
public class Ocean {
    private static final int OCEAN_SIZE = 20;
    private static final int SHIPS_QUANTITY = 13;
    private Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    /**
     * Initializes an instance of {@link Ocean}.
     */
    public Ocean() {

        ships = new Ship[OCEAN_SIZE][OCEAN_SIZE];
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
        for (int i = 0; i < OCEAN_SIZE; i++) {
            for (int j = 0; j < OCEAN_SIZE; j++) {
                EmptySea emptySea = new EmptySea();
                emptySea.placeShipAt(i, j, true, this);
            }
        }
    }

    /**
     * Paces 13 ships randomly.
     */
    void placeAllShipsRandomly() {

        final int fourLengthShip = 4;
        final int sixLengthShip = 6;
        final int nineLengthShip = 9;
        Random random = new Random();
        Ship[] shipsToPlace = new Ship[SHIPS_QUANTITY];
        for (int i = 0; i < SHIPS_QUANTITY; i++) {
            if (i == 0) {
                shipsToPlace[i] = new BattleShip();
            } else if (i == 1) {
                shipsToPlace[i] = new BattleCruiser();
            } else if (i < fourLengthShip) {
                shipsToPlace[i] = new Cruiser();
            } else if (i < sixLengthShip) {
                shipsToPlace[i] = new LightCruiser();
            } else if (i < nineLengthShip) {
                shipsToPlace[i] = new Destroyer();
            } else {
                shipsToPlace[i] = new Submarine();
            }
        }

        for (Ship ship : shipsToPlace) {
            boolean located = false;
            while (!located) {
                int row = random.nextInt(OCEAN_SIZE);
                int column = random.nextInt(OCEAN_SIZE);
                boolean horizontal = random.nextBoolean();
                if (ship.okToPlaceShipAt(row, column, horizontal, this)) {
                    ship.placeShipAt(row, column, horizontal, this);
                    located = true;
                }
            }
        }
    }

    /**
     * Verifies if position was occupied.
     *
     * @param row    int row position.
     * @param column int column position.
     * @return true if position was occupied.
     */
    boolean isOccupied(final int row, final int column) {
        return ships[row][column].getLength() > 1;
    }

    /**
     * Shots a position.
     *
     * @param row    int row position.
     * @param column int column position.
     * @return true if ship was shot.
     */
    boolean shootAt(final int row, final int column) {
        shotsFired++;
        if (ships[row][column].shootAt(row, column)) {
            if (ships[row][column].isSunk()) {
                shipsSunk++;
            }
            hitCount++;
            return true;
        }
        return false;
    }

    /**
     * Obtains the shots fired.
     *
     * @return int shots fired quantity.
     */
    int getShotsFired() {
        return shotsFired;
    }

    /**
     * Obtains the hit count.
     *
     * @return int he hit number.
     */
    int getHitCount() {
        return hitCount;
    }

    /**
     * Obtains the ships sunk quantity.
     *
     * @return int ships sunk number.
     */
    int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * Verifies if is game over.
     *
     * @return true if game over.
     */
    boolean isGameOver() {
        return shipsSunk == SHIPS_QUANTITY;
    }

    /**
     * Gets the ship array.
     *
     * @return matrix of {@link Ship}
     */
    Ship[][] getShipArray() {
        return ships;
    }

    /**
     * Prints the ocean.
     */
    void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < OCEAN_SIZE; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n");

        for (int i = 0; i < OCEAN_SIZE; i++) {
            sb.append(String.format("%2d ", i));
            for (int j = 0; j < OCEAN_SIZE; j++) {
                if (!ships[i][j].wasShootAt(i, j)) {
                    if (!ships[i][j].getShipType().equals("")) {
                        sb.append("a");
                    } else {
                        sb.append(".");
                    }
                } else {
                    sb.append(ships[i][j].toString());
                }
                sb.append("  ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    /**
     * Verifies if the position at the border is occupied.
     *
     * @param row    int row position.
     * @param column int column position.
     * @return true if border of the position is occupied.
     */
    boolean isBorderOccupied(final int row, final int column) {
        int rowPlus = row;
        int rowLess = row;
        int columnPlus = column;
        int columnLess = column;
        if (row + 1 < OCEAN_SIZE) {
            rowPlus += 1;
        }
        if (row - 1 >= 0) {
            rowLess -= 1;
        }
        if (column + 1 < OCEAN_SIZE) {
            columnPlus += 1;
        }
        if (column - 1 >= 0) {
            columnLess -= 1;
        }
        return isOccupied(rowPlus, column) || isOccupied(rowPlus, columnPlus) || isOccupied(rowPlus, columnLess)
                || isOccupied(rowLess, column) || isOccupied(rowLess, columnPlus) || isOccupied(rowLess, columnLess)
                || isOccupied(row, columnLess) || isOccupied(row, columnPlus);
    }
}
