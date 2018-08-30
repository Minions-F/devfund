package org.minions.devfund.marcos.uml;

/**
 * It is in charged to represent a Room object.
 */
public class Room extends MapSite {

    private int roomNumber;
    private MapSite[] mapsites;
    private Wall[] sides;

    /**
     * Initializes an instance of {@link Room}.
     */
    public Room() {
        // Default constructor.
    }

    /**
     * Gets wall side.
     *
     * @param side side number.
     * @return wall object.
     */
    public Wall getSide(final int side) {
        return null;
    }

    /**
     * Sets side.
     *
     * @param number side number.
     * @param wall   wall object.
     */
    public void setSide(final int number, final Wall wall) {
        // Default implementation.
    }

    /**
     * Gets rooms number.
     *
     * @return rooms number.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets room number.
     *
     * @param roomNumber room number.
     */
    public void setRoomNumber(final int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Gets map sites.
     *
     * @return map sites objects arrays.
     */
    public MapSite[] getMapsites() {
        return mapsites.clone();
    }

    /**
     * Sets map sites.
     *
     * @param mapsites map sites objects array.
     */
    public void setMapsites(final MapSite[] mapsites) {
        this.mapsites = mapsites.clone();
    }

    /**
     * Gets sides.
     *
     * @return wall objects array.
     */
    public Wall[] getSides() {
        return sides.clone();
    }

    /**
     * Sets sides.
     *
     * @param sides wall objects array.
     */
    public void setSides(final Wall[] sides) {
        this.sides = sides.clone();
    }
}
