package org.minions.devfund.angela.battleship;

import java.util.Arrays;
import java.util.stream.IntStream;

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
        if (horizontal && column + length - 1 < Ocean.OCEAN_SIZE) {
            return isHorizontalLineOccupied(row, column, ocean);
        } else if (!horizontal && row + length - 1 < Ocean.OCEAN_SIZE) {
            return isVerticalLineOccupied(row, column, ocean);
        }

        return false;
    }

    /**
     * Verifies if horizontal line is occupied in the ocean.
     *
     * @param row    int ro position.
     * @param column int column position.
     * @param ocean  {@link Ocean}.
     * @return true if line is occupied.
     */
    private boolean isHorizontalLineOccupied(final int row, final int column, final Ocean ocean) {
        for (int j = column; j < column + length; j++) {
            if (ocean.isOccupied(row, j) || ocean.isBorderOccupied(row, j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifies if vertical line is occupied in the ocean.
     *
     * @param row    int ro position.
     * @param column int column position.
     * @param ocean  {@link Ocean}.
     * @return true if line is occupied.
     */
    private boolean isVerticalLineOccupied(final int row, final int column, final Ocean ocean) {
        for (int i = row; i < row + length; i++) {
            if (ocean.isOccupied(i, column) || ocean.isBorderOccupied(i, column)) {
                return false;
            }
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
        bowColumn = column;
        bowRow = row;
        setHorizontal(horizontal);
        if (horizontal) {
            for (int j = column; j < column + length; j++) {
                ocean.getShipArray()[row][j] = this;
            }
        } else {
            for (int i = row; i < row + length; i++) {
                ocean.getShipArray()[i][column] = this;
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
            if (!horizontal && column == bowColumn && row >= bowRow && row < bowRow + length) {
                hit[row - bowRow] = true;
                return true;
            } else if (horizontal && row == bowRow && column >= bowColumn && column < bowColumn + length) {
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
        return Arrays.copyOf(hit, length);
    }

    /**
     * Sets the hit.
     *
     * @param finalHit new hit.
     */
    public void setHit(final boolean[] finalHit) {
        hit = Arrays.copyOf(finalHit, length);
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
            return hit[column - bowColumn];
        } else {
            return hit[row - bowRow];
        }
    }
}
