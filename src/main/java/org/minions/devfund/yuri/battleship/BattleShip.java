package org.minions.devfund.yuri.battleship;

import java.util.Arrays;

/**
 * Represents to Battle Ship.
 */
public class BattleShip extends Ship {

  public static final int SQUARES = 8;

  /**
   * Constructor Method.
   */
  public BattleShip() {
    setLength(SQUARES);
    setHit(new boolean[SQUARES]);
    Arrays.fill(getHit(), false);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String getShipType() {
    return "BattleShip";
  }
}
