package org.minions.devfund.marcos.battleship;

/**
 * It is in charged to represent a Light Cruiser ship and it is properties.
 */
public class LightCruiser extends Ship {

    private static final String SHIP_TYPE = "light cruiser";
    private static final int SHIP_LENGTH = 5;

    /**
     * Initializes an instance if {@link LightCruiser}.
     */
    public LightCruiser() {
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
