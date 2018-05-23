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
        return verifyShipBorderFree(row, column, horizontal, ocean);
    }

    private boolean verifyShipBorderFree(int row, int column, boolean horizontal, Ocean ocean) {
        int startRow = row > 0 ? row - 1 : row;
        int startColumn = column > 0 ? column - 1 : column;
        int endRow = horizontal ? row - 1 : row + length;
        int endColumn = horizontal ? column + length : column;
        int border = row == 0 || column ==0 ? 2:3;
        boolean a = false;
        if (checkFreeSpaceForShip(row, column, horizontal, ocean)) {
            if (horizontal) {
                a = checkHorizontalSide(startRow, startColumn, ocean, endColumn, border);
            } else {
                a = checkVerticalSide(startRow, startColumn, ocean, endRow, border);
            }


        }
        return a;

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

    public boolean checkFreeSpaceForShip(int row, int column, boolean horizontal, Ocean ocean) {
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

    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if (length == 1) {
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
        if(isShootAtShipPosition(row,column)){
            if (!hit[index]) {
                hit[index] = true;
                return true;
            }
        }
        return false;
    }
    private boolean isShootAtShipPosition(int row, int column){
        if(horizontal && column >= bowColumn && column < bowColumn + length && row == bowRow){
            return true;
        }
        else{
            if(row >= bowRow && row < bowRow + length && column == bowColumn) {
                return true;
            }
        }
        return false;
    }

    public int getHitIndex(int row, int column) {
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
