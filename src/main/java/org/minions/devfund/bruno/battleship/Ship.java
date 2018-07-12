package org.minions.devfund.bruno.battleship;

import java.util.stream.IntStream;

/**
 * Ship will be an abstract class.
 * We never really want to create a Ship. We always want to create a specific type of Ship.
 * So this means the declaration will be abstract.
 */
public abstract class Ship {

    private static final int SIZE = 20;
    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;

    /**
     * This is an abstract method and therefore has no body.
     *
     * @return String ship type name.
     */
    public abstract String getShipType();

    /**
     * Returns true if it is okay to put a ship of this length with its bow in this location,
     * with the given orientation, and returns false otherwise.
     * The ship must not overlap another ship, or touch another ship (vertically, horizontally).
     *
     * @param row        integer value.
     * @param column     integer value
     * @param horizontal boolean value..
     * @param ocean      Ocean object.
     * @return boolean value.
     */
    public boolean okToPlaceShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
        int columnLength = column + getLength();
        int rowLength = row + getLength();
        return horizontal ? columnLength <= SIZE && !placeShipMatch(row, column, ocean, columnLength, row)
                : rowLength <= SIZE && !placeShipMatch(row, column, ocean, column, rowLength);
    }

    /**
     * The ship must not overlap another ship, or match with another ship in this column and row.
     *
     * @param row       integer value.
     * @param column    integer value.
     * @param ocean     Ocean object.
     * @param colLength integer column length value.
     * @param rowLength integer row length value.
     * @return boolean value.
     */
    private boolean placeShipMatch(final int row, final int column, final Ocean ocean,
                                   final int colLength, final int rowLength) {
        return IntStream.rangeClosed(row - 1, rowLength + 1).anyMatch(i
                -> IntStream.range(column - 1, colLength + 1).anyMatch(j -> handlingArrayIndex(ocean, i, j)));
    }

    /**
     * It must not 'stick out' beyond the array handling the index out of bounds exception.
     *
     * @param ocean Ocean object.
     * @param row   integer value.
     * @param col   integer value.
     * @return boolean value.
     */
    private boolean handlingArrayIndex(final Ocean ocean, final int row, final int col) {
        boolean arrayIndex = false;
        try {
            arrayIndex = !ocean.getShipArray()[row][col].getShipType().equals("empty");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        return arrayIndex;
    }

    /**
     * Puts the ship in the ocean.
     * This involves giving values to the bowRow, bowColumn, and horizontal instance variables in the ship.
     *
     * @param row        integer value.
     * @param column     integer value.
     * @param horizontal boolean value.
     * @param ocean      Ocean object.
     */
    public void placeShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
        bowRow = row;
        bowColumn = column;
        this.horizontal = horizontal;
        if (horizontal) {
            IntStream.range(column, column + getLength()).forEachOrdered(j -> ocean.getShipArray()[row][j] = this);
        } else {
            IntStream.range(row, row + getLength()).forEachOrdered(i -> ocean.getShipArray()[i][column] = this);
        }
    }

    /**
     * Return true if the part of the ship was hit, false otherwise.
     *
     * @param row    integer value.
     * @param column integer value.
     * @return boolean value.
     */
    public boolean wasShootAt(final int row, final int column) {
        return horizontal ? hit[column - bowColumn] : hit[row - bowRow];
    }

    /**
     * If a part of the ship occupies the given row and column, and the ship hasn't been sunk mark
     * a part of the ship as 'hit'.
     *
     * @param row    integer value.
     * @param column integer value.
     * @return boolean value.
     */
    public boolean shootAt(final int row, final int column) {
        boolean rowBowEquals = row == bowRow;
        boolean columnsBowEquals = column == bowColumn;
        int bowColumnLength = bowColumn + length;
        int bowRowLength = bowRow + length;
        int placeHitColumn = column - bowColumn;
        int placeHitRow = row - bowRow;
        if (!isSunk()) {
            return horizontal ? isBowHit(column, rowBowEquals, bowColumnLength, placeHitColumn)
                    : isBowHit(row, columnsBowEquals, bowRowLength, placeHitRow);
        }
        return false;
    }

    /**
     * Marks a part of the ship as 'hit' (in the hit array, 0 indicates the bow) and return true,
     * otherwise return false.
     *
     * @param columnRow integer value.
     * @param bowEquals boolean value.
     * @param length    integer length.
     * @param place     integer hit.
     * @return true if in the hit array, 0 indicates the bow, otherwise return false
     */
    public boolean isBowHit(final int columnRow, final boolean bowEquals, final int length, final int place) {
        if (bowEquals && columnRow < length) {
            hit[place] = true;
            return true;
        }
        return false;
    }

    /**
     * Returns true if every part of the ship has been hit, false otherwise.
     *
     * @return boolean is sunk value.
     */
    public boolean isSunk() {
        for (boolean place : hit) {
            if (!place) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return 'x' if the ship has been sunk, 'S' if it has not been sunk.
     * This method can be used to print out locations in the ocean that have been shot at;
     * it should not be used to print locations that have not been shot at.
     *
     * @return String value.
     */
    @Override
    public String toString() {
        return isSunk() ? "x" : "S";
    }

    /**
     * Gets the ship length.
     *
     * @return integer length value.
     */
    public int getLength() {
        return length;
    }

    /**
     * Gets the ship length.
     *
     * @param length integer value.
     */
    public void setLength(final int length) {
        this.length = length;
    }

    /**
     * Gets the ship hits.
     *
     * @return boolean array hit.
     */
    public boolean[] getHit() {
        return hit.clone();
    }

    /**
     * Sets the ship hits.
     *
     * @param hit boolean array.
     */
    public void setHit(final boolean[] hit) {
        this.hit = hit.clone();
    }

    /**
     * Gets the horizontal boolean value..
     *
     * @return boolean value.
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Sets horizontal place.
     *
     * @param horizontal value.
     */
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Gets Bow Row.
     *
     * @return bow row value.
     */
    public int getBowRow() {
        return bowRow;
    }

    /**
     * Sets bow row.
     *
     * @param bowRow value.
     */
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    /**
     * Gets bow column.
     *
     * @return bow column value.
     */
    public int getBowColumn() {
        return bowColumn;
    }

    /**
     * Sets Bow Column.
     *
     * @param bowColumn value.
     */
    public void setBowColumn(final int bowColumn) {
        this.bowColumn = bowColumn;
    }
}
