package org.minions.devfund.mauricioz.Battleship;

/**
 * abstract class Ship will have different subclases for each ship type.
 * @
 */
public abstract class Ship {
    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;

    /**
     * Getter for bowRow attribute.
     * @return bowRow attribute.
     */
    public int getBowRow() {
        return bowRow;
    }

    /**
     * Getter for bowColumn attribute.
     * @return bowColumn value.
     */
    public int getBowColumn() {
        return bowColumn;
    }

    /**
     * Getter for length attribute.
     * @return length value.
     */
    public int getLength() {
        return length;
    }

    /**
     * Getter for horizontal attribute.
     * @return horizontal value.
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Getter for hit attribute.
     * @return hit value.
     */
    public boolean[] getHit() {
        return this.hit.clone();
    }

    /**
     * Setter for bowRow attribute.
     * @param bowRow value.
     */
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    /**
     * Setter for bowColumn attribute.
     * @param bowColumn value.
     */
    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    /**
     * Setter for length attribute.
     * @param length value.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Setter for horizontal attribute.
     * @param horizontal value.
     */
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Setter for hit attribute.
     * @param hit value.
     */
    public void setHit(final boolean[] hit) {
        this.hit = new boolean[hit.length];
        for (int i = 0; i < hit.length; i++) {
            this.hit[i] = hit[i];
        }
    }

    /**
     * Abstract method to get the ship type.
     * @return shipType.
     */
    public abstract String getShipType();

    /**
     * Method to review if it is possible place a ship on a given coordinates.
     * @param row coordinate.
     * @param column coordinate.
     * @param horizontal position of the ship.
     * @param ocean object.
     * @return true or false.
     */
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, final Ocean ocean) {
        if (startOrFinishOnTheEdge(row, column, ocean) || nothingAround(row, column, horizontal, ocean)) {
            return true;
        }
        return false;
    }

    /**
     * verify is not another ship near of the desired position.
     * @param row value.
     * @param column value.
     * @param horizontal ship direction.
     * @param ocean board.
     * @return true or false.
     */
    private boolean nothingAround(int row, int column, boolean horizontal, final Ocean ocean) {
        if (horizontal && nothingAroundForPlacedHorizontal(row, column, ocean)) {
            return true;
        }
        return false;
    }

    /**
     * verify is no another ship near of the desired position to place the ship.
     * @param row value.
     * @param column value.
     * @param ocean board.
     * @return true or false.
     */
    private boolean nothingAroundForPlacedHorizontal(int row, int column, final Ocean ocean) {
        boolean isEmpty = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (ocean.getShips()[i][j].getShipType() == "empty") {
                    isEmpty = true;
                } else {
                    isEmpty = false;
                }
            }
        }
        return isEmpty;
    }

    /**
     * validate ship position is on the edge of the board.
     * @param row value.
     * @param column value.
     * @param ocean board.
     * @return true or false.
     */
    private boolean startOrFinishOnTheEdge(int row, int column, final Ocean ocean) {
        return row == 0 || column == 0
                || row + this.getLength() == ocean.getShips().length - 1
                || column + this.getLength() == ocean.getShips().length - 1;
    }

    /**
     * action of place a ship onto a valid space into the ocean.
     * @param row coordinate.
     * @param column coordinate.
     * @param horizontal orientation of the ship.
     * @param ocean object.
     */
    public void placeShipAt(int row, int column, boolean horizontal, final Ocean ocean) {
        //TODO
    }

    /**
     * If a part of the ship occupies the given row and column, and the ship hasn’t been sunk,
     * mark that part of the ship as ”hit”.
     * @param row coordinate.
     * @param column coordinate.
     * @return true or false
     */
    public boolean shootAt(int row, int column) {
        //TODO
        return true;
    }

    /**
     * Return true if every part of the ship has been hit, false otherwise.
     * @return true or false
     */
    public boolean isSunk() {
        return true;
    }

    /**
     * mark into the ocean the shot.
     * @return x or S according the result.
     */
    @Override
    public String toString() {
        if (isSunk()) {
            return "x";
        }
        return "S";
    }
}
