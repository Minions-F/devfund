package org.minions.devfund.yuri.battleship;

import java.util.Arrays;

/**
 * Represents to Cruiser.
 */
public class Cruiser extends Ship {

  public static final int SQUARES = 6;

  /**
   * Constructor method.
   */
  public Cruiser() {
    setLength(SQUARES);
    setHit(new boolean[SQUARES]);
    Arrays.fill(getHit(), false);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String getShipType() {
    return "Cruiser";
  }
}
