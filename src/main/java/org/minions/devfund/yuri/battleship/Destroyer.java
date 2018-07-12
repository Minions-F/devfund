package org.minions.devfund.yuri.battleship;

import java.util.Arrays;

/**
 * Represents a Destroyer.
 */
public class Destroyer extends Ship {

  public static final int SQUARES = 4;

  /**
   * Constructor method.
   */
  public Destroyer() {
    setLength(SQUARES);
    setHit(new boolean[SQUARES]);
    Arrays.fill(getHit(), false);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String getShipType() {
    return "Destroyer";
  }
}
