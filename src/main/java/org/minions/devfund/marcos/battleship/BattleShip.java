package org.minions.devfund.marcos.battleship;

/**
 * It is in charged to represent a Battle Ship and it is properties.
 */
public class BattleShip extends Ship {

    private static final String SHIP_TYPE = "battleship";
    private static final int SHIP_LENGTH = 8;

    /**
     * Initializes an instance if {@link BattleShip}.
     */
    public BattleShip() {
        setLength(SHIP_LENGTH);
        setHit(new boolean[SHIP_LENGTH]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return SHIP_TYPE;
    }
}
