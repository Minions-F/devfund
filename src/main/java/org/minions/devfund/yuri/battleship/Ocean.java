package org.minions.devfund.yuri.battleship;


import java.util.stream.IntStream;

/**
 * Represents the ocean in the game.
 */
public class Ocean {
    public static final int SHIPS_AMOUNT = 20;
    public static final int SHIPS_SUNK = 13;
    private Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    /**
     * Constructor Method.
     */
    public Ocean() {
        ships = new Ship[SHIPS_AMOUNT][SHIPS_AMOUNT];
        fillShips();
        shipsSunk = SHIPS_SUNK;
        shotsFired = 0;
        hitCount = 0;
    }

    /**
     * Fills the ships with empty seas.
     */
    private void fillShips() {
        IntStream.rangeClosed(0, ships.length).forEach(rows
                -> IntStream.rangeClosed(0, ships.length).forEach(column
                -> ships[rows][column] = new EmptySea()));
    }

    /**
     * Gets the status of an specific position.
     * @param row row position.
     * @param column column position.
     * @return <code>true, if the position contains a ship</code>
     *      <code>false, if ,it does not</code>
     */
    public boolean isOccupied(final int row, final int column) {
        return !(ships[row][column] instanceof EmptySea);
    }

    /**
     *
     * @param row
     * @param column
     */
    public boolean shootAt(final int row, final int column) {
        return isOccupied(row, column);
    }
}
