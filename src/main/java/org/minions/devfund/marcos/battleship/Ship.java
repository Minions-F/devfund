package org.minions.devfund.marcos.battleship;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * It is in charge to represent a Ship and it is properties.
 */
public abstract class Ship {

    private static final String SHIP_SUNK_CHAR = "x";
    private static final String SHIP_NOT_SUNK_CHAR = "S";

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;

    /**
     * Gets the ship type.
     *
     * @return ship type value.
     */
    public abstract String getShipType();

    /**
     * Checks if the ship is ok to place the ship in the ocean.
     *
     * @param row        row position.
     * @param column     column position.
     * @param horizontal horizontal disposition flag.
     * @param ocean      {@link Ocean}.
     * @return true if the ship is ok to place in the ocean.
     */
    public boolean okToPlaceShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
        int columnBound = column + getLength();
        int rowBound = row + getLength();
        return horizontal ? columnBound < Ocean.LENGTH && isPlaceFree(row, column, horizontal, ocean)
                : rowBound < Ocean.LENGTH && isPlaceFree(row, column, horizontal, ocean);
    }

    /**
     * Places a ship at the parameter's specified location.
     *
     * @param row        row position.
     * @param column     column position.
     * @param horizontal horizontal disposition flag.
     * @param ocean      {@link Ocean}.
     */
    public void placeShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;
        getShipPositions().forEach(pos -> ocean.getShipArray()[pos.x][pos.y] = this);
    }

    /**
     * Checks if the place is free in the ocean.
     *
     * @param row        row position.
     * @param column     column position.
     * @param horizontal horizontal disposition flag.
     * @param ocean      {@link Ocean}.
     * @return true if the place is free.
     */
    private boolean isPlaceFree(final int row, final int column, final boolean horizontal, final Ocean ocean) {
        return getShipSurroundPlaces(row, column, horizontal).stream()
                .noneMatch(point -> ocean.isOccupied(point.x, point.y));
    }

    /**
     * Gets all the ship's surround locations.
     *
     * @param row        row position.
     * @param column     column position.
     * @param horizontal horizontal position flag.
     * @return all the ship's surround positions as point list.
     */
    private List<Point> getShipSurroundPlaces(final int row, final int column, final boolean horizontal) {
        List<Point> points = new ArrayList<>();
        int rowMin = Math.max(0, row - 1);
        int rowMax = Math.min(Ocean.LENGTH - 1, horizontal ? row + 1 : row + length - 1);
        int colMin = Math.max(0, column - 1);
        int colMax = Math.min(Ocean.LENGTH - 1, horizontal ? column + length - 1 : column + 1);
        IntStream.rangeClosed(rowMin, rowMax).forEach(newRow ->
                IntStream.rangeClosed(colMin, colMax).forEach(newCol -> points.add(new Point(newRow, newCol))));
        return points;
    }

    /**
     * Checks if the given location contains a ship (not an EmptySea).
     *
     * @param row    row to be checked.
     * @param column column to be checked.
     * @return true if the location contains a ship.
     */
    public boolean shootAt(final int row, final int column) {
        if (!isSunk() && isHittable(row, column)) {
            int hitPosition = horizontal ? column - bowColumn : row - bowRow;
            hit[hitPosition] = true;
            return true;
        }
        return false;
    }

    /**
     * Checks if the position is hittable.
     *
     * @param row    row position.
     * @param column column position.
     * @return true if it is hittable.
     */
    private boolean isHittable(final int row, final int column) {
        return getShipPositions().stream().anyMatch(pos -> pos.x == row && pos.y == column);
    }

    /**
     * Gets the rows positions.
     *
     * @return rows positions list.
     */
    private List<Point> getShipPositions() {
        return horizontal ? IntStream.range(bowColumn, bowColumn + length).boxed()
                .map(col -> new Point(bowRow, col)).collect(Collectors.toList())
                : IntStream.range(bowRow, bowRow + length).boxed()
                .map(row -> new Point(row, bowColumn)).collect(Collectors.toList());
    }

    /**
     * Checks if the ship is sunk.
     *
     * @return true if the ship is sunk.
     */
    public boolean isSunk() {
        return IntStream.range(0, hit.length).mapToObj(e -> hit[e]).allMatch(e -> e);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        return isSunk() ? SHIP_SUNK_CHAR : SHIP_NOT_SUNK_CHAR;
    }

    /**
     * Gets the BowRow.
     *
     * @return BowRow value.
     */
    public int getBowRow() {
        return bowRow;
    }

    /**
     * Sets the BowRow.
     *
     * @param bowRow BowRow value.
     */
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    /**
     * Gets the BowColumn.
     *
     * @return BowColumn value.
     */
    public int getBowColumn() {
        return bowColumn;
    }

    /**
     * Sets the BowColumn.
     *
     * @param bowColumn BowColumn value.
     */
    public void setBowColumn(final int bowColumn) {
        this.bowColumn = bowColumn;
    }

    /**
     * Gets the length.
     *
     * @return length value.
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length.
     *
     * @param length length value.
     */
    public void setLength(final int length) {
        this.length = length;
    }

    /**
     * Checks if ship is in horizontal position.
     *
     * @return true if ship is in horizontal position.
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Sets the ship's horizontal position flag.
     *
     * @param horizontal horizontal position flag value.
     */
    public void setHorizontal(final boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Gets the hit places.
     *
     * @return hits places values.
     */
    public boolean[] getHit() {
        return hit.clone();
    }

    /**
     * Sets the hit places.
     *
     * @param hit hits places values.
     */
    public void setHit(final boolean[] hit) {
        this.hit = hit.clone();
    }
}
