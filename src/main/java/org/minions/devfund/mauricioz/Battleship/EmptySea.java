package org.minions.devfund.mauricioz.Battleship;

/**
 * class to create empty places in the ocean.
 */
public class EmptySea extends Ship {

    private static final int FINAL_VALUE = 1;
    /**
     * Constructor.
     */
    public  EmptySea() {
        setLength(FINAL_VALUE);
    }

    /**
     * overriding shootAt method to return always false.
     * @param row coordinate.
     * @param column coordinate.
     * @return false
     */
    @Override
    public boolean shootAt(int row, int column) {
        return false;
    }

    /**
     * overriding method.
     * @return false.
     */
    @Override
    public boolean isSunk() {
        return false;
    }

    /**
     * overriding method.
     * @return empty character.
     */
    @Override
    public String toString() {
        return "e";
    }

    /**
     * get the suip type.
     * @return empty.
     */
    @Override
    public String getShipType() {
        return "empty";
    }

}
