package org.minions.devfund.angela.battleship;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Manages all Ships.
 */
public abstract class Ship {
    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;

    /**
     * Obtains the ship type.
     *
     * @return String with the ship type.
     */
    abstract String getShipType();

    /**
     * Verifies if it is possible to place a ship in a position.
     *
     * @param row        the row where to place the ship.
     * @param column     the column where to place the ship.
     * @param horizontal the orientation to position the ship.
     * @param ocean      {@link Ocean}.
     * @return true if is possible to place a ship in the position.
     */
    boolean okToPlaceShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
        try {
            if (horizontal) {
                for (int i = row; i < row + length; i++) {
                    if (ocean.isOccupied(i, column)) {
                        return false;
                    }
                }

            } else {
                for (int j = column; j < column + length; j++) {
                    if (ocean.isOccupied(row, j)) {
                        return false;
                    }
                }
            }

        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    /**
     * Places a ship in a position.
     *
     * @param row        the row where to place the ship.
     * @param column     the column where to place the ship.
     * @param horizontal the orientation to position the ship.
     * @param ocean      {@link Ocean}.
     */
    void placeShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
        if (horizontal) {
            for (int i = row; i < row + length; i++) {
                bowColumn = column;
                bowRow = row;
                ocean.getShipArray()[i][column] = this;
            }

        } else {
            for (int j = column; j < column + length; j++) {
                bowColumn = column;
                bowRow = row;
                ocean.getShipArray()[row][j] = this;
            }
        }
    }

    /**
     * Shots at a certain position.
     *
     * @param row    int the row position.
     * @param column int the column position.
     * @return true if a ship was shot.
     */
    boolean shootAt(final int row, final int column) {
        if (!isSunk()) {
            if (horizontal && column == bowColumn && row >= bowRow && row < bowRow + length) {
                hit[row - bowRow] = true;
                return true;
            } else if (!horizontal && row == bowRow && column >= bowColumn && column < bowColumn + length) {
                hit[column - bowColumn] = true;
                return true;
            }
        }
        return false;
    }

    /**
     * Verifies if a ship was sunk.
     *
     * @return tru if the ship was sunk.
     */
    boolean isSunk() {
       return IntStream.range(0, hit.length)
                .mapToObj(idx -> hit[idx]).allMatch(element -> element);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        return isSunk() ? "x" : "S";
    }

    /**
     * Gets the bow row.
     *
     * @return int bow row.
     */
    public int getBowRow() {
        return bowRow;
    }

    /**
     * Sets the bow rew value.
     *
     * @param newBowRow int new bow row value.
     */
    public void setBowRow(final int newBowRow) {
        this.bowRow = newBowRow;
    }

    /**
     * Gets the bowl column.
     *
     * @return int the bowl column value.
     */
    public int getBowColumn() {
        return bowColumn;
    }

    /**
     * Sets the bowl column.
     *
     * @param newBowColumn int new bowl column value.
     */
    public void setBowColumn(final int newBowColumn) {
        this.bowColumn = newBowColumn;
    }

    /**
     * Gets the length of the ship.
     *
     * @return int ship length.
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length of the ship.
     *
     * @param finalLength the new length vale.
     */
    public void setLength(final int finalLength) {
        this.length = finalLength;
    }

    /**
     * Gets horizontal value.
     *
     * @return tru if ship is horizontal.
     */
    public boolean getHorizontal() {
        return horizontal;
    }

    /**
     * Sets horizontal value.
     *
     * @param finalHorizontal boolean new horizontal value.
     */
    public void setHorizontal(final boolean finalHorizontal) {
        this.horizontal = finalHorizontal;
    }

    /**
     * Gets the hit.
     *
     * @return the hit.
     */
    public boolean[] getHit() {
        return hit;
    }

    /**
     * Sets the hit.
     *
     * @param finalHit new hit.
     */
    public void setHit(final boolean[] finalHit) {
        hit = finalHit;
    }

    /**
     * Verifies if a ship was shot in a certain position.
     *
     * @param row    int row position.
     * @param column int column position.
     * @return true if the ship was shot in that position.
     */
    public boolean wasShootAt(final int row, final int column) {
        if (horizontal) {
            return hit[row - bowRow];
        } else {
            return hit[column - bowColumn];
        }
    }
}
