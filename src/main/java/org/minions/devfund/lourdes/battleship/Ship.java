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

    abstract String getShipType();

    /**
     * Method that validate if the given position is available to be set with a ship.
     *
     * @param row        row position of the ocean ship array.
     * @param column     column position of the ocean ship array.
     * @param horizontal true if the position is horizontal.
     * @param ocean      Ocean where the ship will be set
     * @return a boolean, true if the given position is free and false otherwise.
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if (row < 0 || row > ocean.getShipArray().length || column < 0 || column > ocean.getShipArray().length) {
            return false;
        }
        return verifyShipBorderFree(row, column, horizontal, ocean);
    }

    /**
     * Method that verify if the
     * @param row
     * @param column
     * @param horizontal
     * @param ocean
     * @return
     */
    private boolean verifyShipBorderFree(int row, int column, boolean horizontal, Ocean ocean) {
        int startRow = row > 0 ? row - 1 : row;
        int startColumn = column > 0 ? column - 1 : column;
        int endRow = horizontal ? row - 1 : row + length;
        int endColumn = horizontal ? column + length : column;
        int borderLimit = row == 0 || column == 0 ? 2 : 3;
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

    private boolean checkHorizontalSide(int row, int column, Ocean ocean, int columnLimit, int rowLimit) {
        for (int i = row; i < row + rowLimit; i++) {
            for (int j = column; j < columnLimit; j++) {
                if (ocean.isOccupied(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkVerticalSide(int row, int column, Ocean ocean, int borderLimit, int columnLimit) {
        for (int i = column; i < column + columnLimit; i++) {
            for (int j = row; j < borderLimit; j++) {
                if (ocean.isOccupied(j, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkFreeSpaceForShip(int row, int column, boolean horizontal, Ocean ocean) {
        try {
            for (int i = 0; i < length; i++) {
                if (horizontal && ocean.isOccupied(row, column + i)) {
                    return false;

                } else if ((ocean.isOccupied(row + i, column))) {
                    return false;
                }
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException a) {
            return false;
        }
    }

    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
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

    private boolean isShootAtShipPosition(int row, int column) {
        return (horizontal && column >= bowColumn && column < bowColumn + length && row == bowRow) ||
                (row >= bowRow && row < bowRow + length && column == bowColumn);
    }

    private int getHitIndex(int row, int column) {
        int index;
        if (horizontal) {
            index = column - bowColumn;
        } else {
            index = row - bowRow;
        }
        return index;
    }

    public boolean isSunk() {
        for (boolean element : hit) if (!element) return false;
        return true;
    }

    public int getBowRow() {
        return bowRow;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public boolean[] getHit() {
        return hit;
    }

    public void setHit(boolean[] hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return isSunk() ? "x" : "S";
    }

}
