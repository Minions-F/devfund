package org.minions.devfund.marcos.uml;

/**
 * It is in charged to represent a Randomized Maze Game object.
 */
public class Maze {

    private Room[] rooms;

    /**
     * Initializes an instance of {@link Maze}.
     */
    public Maze() {
        // Default constructor.
    }

    /**
     * Adds room.
     *
     * @param room room object.
     */
    public void addRoom(final Room room) {
        // Default implementation.
    }

    /**
     * Gets rooms.
     *
     * @return rooms attribute.
     */
    public Room[] getRooms() {
        return rooms.clone();
    }

    /**
     * Sets rooms.
     *
     * @param rooms rooms objects array.
     */
    public void setRooms(final Room[] rooms) {
        this.rooms = rooms.clone();
    }
}
