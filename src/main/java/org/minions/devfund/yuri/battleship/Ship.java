package org.minions.devfund.yuri.battleship;

/**
 * This class represent to ship.
 */
public abstract class Ship {
  private int bowRow;
  private int bowColumn;
  private int length;
  private boolean horizontal;
  private boolean[] hit;

  /**
   * Constructor method.
   */
  public Ship() {
    //default constructor.
  }

  /**
   * Gets the ShipType.
   *
   * @return ship type.
   */
  public abstract String getShipType();

  /**
   * Verifies that is possible to place a ship over an specific position.
   *
   * @param row        row value.
   * @param column     column value.
   * @param horizontal horizontal value.
   * @param ocean      the ocean.
   * @return <code>true, if is possible to place it.</code>
   * <code>false, if it is not.</code>
   */
  public boolean okToPlaceShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
    return true;
  }

  /**
   * Puts a ship in the ocean.
   *
   * @param row        row position.
   * @param column     column position.
   * @param horizontal horizontal.
   * @param ocean      the ocean.
   */
  public void placeShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
  }

  /**
   * Verifies that a ship has been sunk.
   *
   * @param row    row position.
   * @param column column position.
   * @return <code>true, if the ship has been hunk.</code>
   * <code>false, if it is not.</code>
   */
  public boolean shootAt(final int row, final int column) {
    return true;
  }

  /**
   * Verifies that a ship has been hit.
   *
   * @return <code>true, if the ship has been hit.</code>
   * <code>false, if it is not.</code>
   */
  public boolean isSunk() {
    return true;
  }

  /**
   * Gets hit values.
   *
   * @return hit values.
   */
  public boolean[] getHit() {
    return hit;
  }

  /**
   * Sets the hit.
   *
   * @param newHit new values for hit.
   */
  public void setHit(final boolean[] newHit) {
    hit = newHit;
  }

  /**
   * Gets the ship length.
   *
   * @return length.
   */
  public int getLength() {
    return length;
  }

  /**
   * Sets the ship length.
   *
   * @param length new length.
   */
  public void setLength(final int length) {
    this.length = length;
  }

  /**
   * Gets the bow row.
   *
   * @return bow row.
   */
  public int getBowRow() {
    return bowRow;
  }

  /**
   * Sets the bow row value.
   *
   * @param bowRow int new bow row value.
   */
  public void setBowRow(final int bowRow) {
    this.bowRow = bowRow;
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
   * Sets the bow bow column value.
   *
   * @param bowColumn bow column value.
   */
  public void setBowColumn(final int bowColumn) {
    this.bowColumn = bowColumn;
  }

  /**
   * Gets horizontal value.
   *
   * @return horizontal.
   */
  public boolean getHorizontal() {
    return horizontal;
  }

  /**
   * Sets horizontal value.
   *
   * @param horizontal horizontal value.
   */
  public void setHorizontal(final boolean horizontal) {
    this.horizontal = horizontal;
  }
}
