package org.minions.devfund.marcos.battleship;

/**
 * It is in charged to represent a Submarine ship and it is properties.
 */
public class Submarine extends Ship {

    private static final String SHIP_TYPE = "submarine";
    private static final int SHIP_LENGTH = 3;

    /**
     * Initializes an instance if {@link Submarine}.
     */
    public Submarine() {
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
