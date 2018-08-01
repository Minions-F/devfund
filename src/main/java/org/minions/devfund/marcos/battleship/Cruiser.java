package org.minions.devfund.marcos.battleship;

/**
 * It is in charged to represent a Cruiser ship and it is properties.
 */
public class Cruiser extends Ship {

    private static final String SHIP_TYPE = "cruiser";
    private static final int SHIP_LENGTH = 6;

    /**
     * Initializes an instance if {@link Cruiser}.
     */
    public Cruiser() {
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
