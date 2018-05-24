package org.minions.devfund.lourdes.battleship;

/**
 * Class that manages all operations related to the Ship.
 */
public abstract class Ship {
    private int bowRow;
    private int bowColumn;
    protected int length;
    private boolean horizontal;
    protected boolean[] hit;

    /**
     * Abstract method that will be defined.
     *
     * @return ship type.
     */
    abstract String getShipType();

    /**
     * Method that validate if the given position is available to be set with a ship.
     *
     * @param row        row position of the ocean ship array.
     * @param column     column position of the ocean ship array.
     * @param horizontal true if the position is horizontal.
     * @param ocean      Ocean where the ship will be set.
     * @return a boolean, true if the given position is free and false otherwise.
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, final Ocean ocean) {
        if (row < 0 || row > ocean.getShipArray().length || column < 0 || column > ocean.getShipArray().length) {
            return false;
        }
        return verifyShipBorderFree(row, column, horizontal, ocean);
    }

    /**
     * Method that verify if the given position is free to place a ship.
     *
     * @param row        row position.
     * @param column     column position.
     * @param horizontal true if the position is horizontal.
     * @param ocean      Ocean where the ship will be set.
     * @return a boolean, true if the given position is free and false otherwise.
     */
    private boolean verifyShipBorderFree(int row, int column, boolean horizontal, final Ocean ocean) {
        final int totalLine = 3;
        int startRow = row > 0 ? row - 1 : row;
        int startColumn = column > 0 ? column - 1 : column;
        int endRow = horizontal ? row - 1 : row + length;
        int endColumn = horizontal ? column + length : column;
        int borderLimit = row == 0 || column == 0 ? 2 : totalLine;
        boolean isFreePosition = false;
        if (checkFreeSpaceForShip(row, column, horizontal, ocean)) {
            if (horizontal) {
                isFreePosition = checkHorizontalSide(startRow, startColumn, ocean, endColumn, borderLimit);
            } else {
                isFreePosition = checkVerticalSide(startRow, startColumn, ocean, endRow, borderLimit);
            }
        }
        return isFreePosition;
    }

    /**
     * Method that verify if all horizontal sides are free.
     *
     * @param row         row position.
     * @param column      column position.
     * @param ocean       Ocean object.
     * @param columnLimit column limit.
     * @param rowLimit    row limit.
     * @return true if all horizontal sides are free, false otherwise.
     */
    private boolean checkHorizontalSide(int row, int column, final Ocean ocean, int columnLimit, int rowLimit) {
        for (int i = row; i < row + rowLimit; i++) {
            for (int j = column; j < columnLimit; j++) {
                if (ocean.isOccupied(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method that verify all vertical sides are free.
     *
     * @param row         row position.
     * @param column      column position.
     * @param ocean       Ocean object.
     * @param rowLimit    row limit.
     * @param columnLimit column limit.
     * @return true if all vertical sides are free, false otherwise.
     */
    private boolean checkVerticalSide(int row, int column, final Ocean ocean, int rowLimit, int columnLimit) {
        for (int i = column; i < column + columnLimit; i++) {
            for (int j = row; j < rowLimit; j++) {
                if (ocean.isOccupied(j, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method that check if a given position is free to place a ship.
     *
     * @param row        row position.
     * @param column     column position.
     * @param horizontal ship orientation.
     * @param ocean      Ocean object where the ship will be placed.
     * @return True if the ship is able to be placed in the given position, false otherwise.
     */
    private boolean checkFreeSpaceForShip(int row, int column, boolean horizontal, final Ocean ocean) {
        try {
            for (int i = 0; i < length; i++) {
                if (horizontal && ocean.isOccupied(row, column + i)) {
                    return false;

                } else if (ocean.isOccupied(row + i, column)) {
                    return false;
                }
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException a) {
            return false;
        }
    }

    /**
     * Method tha place a ship at the ocean.
     *
     * @param row        row position.
     * @param column     column position.
     * @param horizontal true if the ship will be placed horizontally and false if it will be vertically.
     * @param ocean      Ocean object where the ship will be placed.
     */
    void placeShipAt(int row, int column, boolean horizontal, final Ocean ocean) {
        bowRow = row;
        bowColumn = column;
        this.horizontal = horizontal;
        for (int i = 0; i < length; i++) {
            if (horizontal) {
                ocean.getShipArray()[bowRow][bowColumn + i] = this;

            } else {
                ocean.getShipArray()[bowRow + i][bowColumn] = this;
            }
        }
    }

    /**
     * Method that shoot at a given position.
     *
     * @param row    row position.
     * @param column column position.
     * @return true if the shoot was accurate, false otherwise.
     */
    public boolean shootAt(int row, int column) {
        int index = getHitIndex(row, column);
        if (isShootAtShipPosition(row, column) && !isSunk()) {
            if (!hit[index]) {
                hit[index] = true;
            }
            return true;
        }
        return false;
    }

    /**
     * Method that verify if the a given position belongs to the ship position.
     *
     * @param row    row position.
     * @param column column position.
     * @return true if the given position belong to the ship position, false otherwise.
     */
    private boolean isShootAtShipPosition(int row, int column) {
        return horizontal && column >= bowColumn && column < bowColumn + length && row == bowRow
                || row >= bowRow && row < bowRow + length && column == bowColumn;
    }

    /**
     * Method that return the corresponding hit index given a row and column.
     *
     * @param row    row position.
     * @param column column position.
     * @return the hit index related to the given position.
     */
    int getHitIndex(int row, int column) {
        return horizontal ? column - bowColumn : row - bowRow;
    }

    /**
     * Method that verify if the ships is sunk.
     *
     * @return true if the ship is sunk, false otherwise.
     */
    public boolean isSunk() {
        for (boolean element : hit) {
            if (!element) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that return the ship bow row.
     *
     * @return the bow row.
     */
    int getBowRow() {
        return bowRow;
    }

    /**
     * Method that set the bow row.
     *
     * @param bowRow bow row data.
     */
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    /**
     * Methot that returns the bow column.
     *
     * @return the bow column.
     */
    public int getBowColumn() {
        return bowColumn;
    }

    /**
     * Method that set the bow column data.
     *
     * @param bowColumn bow column.
     */
    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    /**
     * Method that return the ship length.
     *
     * @return the shiop length.
     */
    public int getLength() {
        return length;
    }

    /**
     * Method that set the ship length.
     *
     * @param length length data.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Method that return the orientation of the ship.
     *
     * @return true if the ship is placed horizontally, false otherwise.
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Method that set the orientation of the ship.
     *
     * @param horizontal define if the ship orientation is vertical or horizontal.
     */
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Method that return the hit array.
     *
     * @return hit array.
     */
    public boolean[] getHit() {
        return hit.clone();
    }

    @Override
    public String toString() {
        return isSunk() ? "x" : "S";
    }
}
