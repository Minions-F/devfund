package org.minions.devfund.mauricioz.Battleship;

/**
 * battleship class.
 */
public class BattleShip extends Ship {
    private static final int SIZE = 8;

    /**
     * constructor.
     */
    public BattleShip() {
        this.setLength(SIZE);
    }

    @Override
    public String getShipType() {
        return "battleship";
    }
}
