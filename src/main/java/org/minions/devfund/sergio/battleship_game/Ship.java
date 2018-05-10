package org.minions.devfund.sergio.battleship_game;

public abstract class Ship {

    private int tableRow;
    private int tableColumn;
    private int size;
    private boolean[] hit;

    public abstract String getShipType();

    public void placeShipAt(int row, int column) {
    }
    public boolean currentHit(int row, int column) {
        return false;
    }

    public int getTableColumn() {
        return tableColumn;
    }

    public void setTableColumn(int tableColumn) {
        this.tableColumn = tableColumn;
    }

    public int getTableRow() {
        return tableRow;
    }

    public void setTableRow(int tableRow) {
        this.tableRow = tableRow;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public boolean[] getHit() {
        return hit;
    }

    public void setHit(boolean[] hit) {
        this.hit = hit;
    }
}
