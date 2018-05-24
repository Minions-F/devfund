package org.minions.devfund.marcos.battleship;

/**
 * It is in charged to represent a Battle Cruiser ship and it is properties.
 */
public class BattleCruiser extends Ship {

    private static final String SHIP_TYPE = "battlecruiser";
    private static final int SHIP_LENGTH = 7;

    /**
     * Initializes an instance if {@link BattleCruiser}.
     */
    public BattleCruiser() {
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
