package org.minions.devfund.yuri.battleship;

import java.util.Arrays;

/**
 * Represents to light cruiser.
 */
public class LightCruiser extends Ship {

  public static final int SQUARES = 5;

  /**
   * Constructor method.
   */
  public LightCruiser() {
    setLength(SQUARES);
    setHit(new boolean[SQUARES]);
    Arrays.fill(getHit(), false);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String getShipType() {
    return "LightCruiser";
  }
}
