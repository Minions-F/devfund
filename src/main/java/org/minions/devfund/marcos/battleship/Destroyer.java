package org.minions.devfund.marcos.battleship;

/**
 * It is in charged to represent a Destroyer ship and it is properties.
 */
public class Destroyer extends Ship {

    private static final String SHIP_TYPE = "destroyer";
    private static final int SHIP_LENGTH = 4;

    /**
     * Initializes an instance if {@link Destroyer}.
     */
    public Destroyer() {
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
