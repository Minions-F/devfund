package org.minions.devfund.marcos.uml;

/**
 * It is in charged to represent a Door object.
 */
public class Door implements MapSite {

    private boolean isOpen;
    private Room room1;
    private Room room2;

    /**
     * Initializes an instance of {@link Door}.
     */
    public Door() {
        // Default constructor.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void enter() {
        // Default implementation.
    }

    /**
     * Checks if door is open.
     *
     * @return true if it is open.
     */
    public boolean isOpen() {
        return isOpen;
    }

    /**
     * Sets open flag.
     *
     * @param open open flag value.
     */
    public void setOpen(final boolean open) {
        isOpen = open;
    }

    /**
     * Gets Room one.
     *
     * @return room object.
     */
    public Room getRoom1() {
        return room1;
    }

    /**
     * Sets Room one.
     *
     * @param room1 room object.
     */
    public void setRoom1(final Room room1) {
        this.room1 = room1;
    }

    /**
     * Gets Room two.
     *
     * @return room object.
     */
    public Room getRoom2() {
        return room2;
    }

    /**
     * Sets room two.
     *
     * @param room2 room object.
     */
    public void setRoom2(final Room room2) {
        this.room2 = room2;
    }
}
