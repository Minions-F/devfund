package org.minions.devfund.lourdes.battleship;

public abstract class Ship {
    private int bowRow;
    private int bowColumn;
    protected int length;
    private boolean horizontal;
    protected boolean[] hit;

    abstract String getShipType();

    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if (row < 0 || row > ocean.getShipArray().length || column < 0 || column > ocean.getShipArray().length) {
            return false;
        }
        return (verifyShipSpaceFree(row, column, horizontal, ocean, length) && verifyShipBorderFree(row, column, horizontal, ocean));
    }

    private boolean verifyShipBorderFree(int row, int column, boolean horizontal, Ocean ocean) {
        boolean topRow = true;
        boolean bottomRow = true;
        boolean rightRow = true;
        boolean leftRow = true;
        if (row > 0 && row < ocean.getShipArray().length) {
            topRow = verifyShipSpaceFree(row - 1, column - 1, horizontal, ocean, length + 2);
            bottomRow = verifyShipSpaceFree(row + 1, column - 1, horizontal, ocean, length + 2);
        }
        if (column > 0 && column < ocean.getShipArray().length) {
            rightRow = !ocean.isOccupied(row, length + 1);
            leftRow = !ocean.isOccupied(row, column - 1);
        }

        return topRow && bottomRow && rightRow && leftRow;


    }

    private boolean verifyShipSpaceFree(int row, int column, boolean horizontal, Ocean ocean, int lenght) {
        try {
            for (int i = 0; i < lenght; i++) {
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

    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if (length == 1){
            bowRow = row;
            bowColumn = column;
            ocean.getShipArray()[row][column] = this;

        } else if (okToPlaceShipAt(row, column, horizontal, ocean)) {
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
    }

    public boolean shootAt(int row, int column) {
        int index = getHitIndex(row, column);
        if (!hit[index]) {
            hit[index] = true;
            return true;
        }
        return false;
    }
    public int getHitIndex(int row, int column){
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
