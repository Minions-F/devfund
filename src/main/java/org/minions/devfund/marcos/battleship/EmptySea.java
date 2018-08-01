package org.minions.devfund.marcos.battleship;

/**
 * It is in charged to represent an Empty Sea and it is properties.
 */
public class EmptySea extends Ship {

    private static final String SHIP_TYPE = "empty";
    private static final String NOTHING_FIRED_CHAR = "-";
    private static final String NEVER_FIRED_CHAR = ".";
    private static final int SHIP_LENGTH = 1;

    /**
     * Initializes an instance if {@link EmptySea}.
     */
    public EmptySea() {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean shootAt(int row, int column) {
        boolean[] hitArray = {true};
        setHit(hitArray);
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSunk() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getHit()[0] ? NOTHING_FIRED_CHAR : NEVER_FIRED_CHAR;
    }
}
