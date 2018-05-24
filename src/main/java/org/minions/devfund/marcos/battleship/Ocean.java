package org.minions.devfund.marcos.battleship;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

/**
 * It is in charge to represent a Ocean and it is ships.
 */
public class Ocean {

    private static final Map<ShipType, Integer> OCEAN_SHIPS = new EnumMap<>(ShipType.class);
    private static final int SHIPS_NUMBER = 13;
    private static final int BATTLESHIP_NUMBER = 1;
    private static final int BATTLE_CRUISER_NUMBER = 1;
    private static final int CRUISER_NUMBER = 2;
    private static final int LIGHT_CRUISER_NUMBER = 2;
    private static final int DESTROYER_NUMBER = 3;
    private static final int SUBMARINE_NUMBER = 4;
    static final int LENGTH = 20;

    static {
        OCEAN_SHIPS.put(ShipType.BATTLESHIP, BATTLESHIP_NUMBER);
        OCEAN_SHIPS.put(ShipType.BATTLE_CRUISER, BATTLE_CRUISER_NUMBER);
        OCEAN_SHIPS.put(ShipType.CRUISER, CRUISER_NUMBER);
        OCEAN_SHIPS.put(ShipType.LIGHT_CRUISER, LIGHT_CRUISER_NUMBER);
        OCEAN_SHIPS.put(ShipType.DESTROYER, DESTROYER_NUMBER);
        OCEAN_SHIPS.put(ShipType.SUBMARINE, SUBMARINE_NUMBER);
    }

    private Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    /**
     * Initializes a new instance of {@link Ocean}.
     */
    public Ocean() {
        ships = new Ship[LENGTH][LENGTH];
        generateEmptyOcean();
    }

    /**
     * Fills the ships array with {@link EmptySea} instances.
     */
    private void generateEmptyOcean() {
        Arrays.stream(ships).forEach(row -> Arrays.fill(row, new EmptySea()));
    }

    /**
     * Places all the ships randomly.
     */
    public void placeAllShipsRandomly() {
        OCEAN_SHIPS.forEach(this::placeShipType);
    }

    /**
     * Places a specific ship type in ocean.
     *
     * @param shipType ship type enum value.
     * @param number   number of ships to be placed.
     */
    private void placeShipType(final ShipType shipType, final int number) {
        int shipNumber = number;
        while (shipNumber-- > 0) {
            placeShipType(shipType);
        }
    }

    /**
     * Places a specific single ship type in ocean.
     *
     * @param shipType ship type enum value.
     */
    private void placeShipType(final ShipType shipType) {
        Random random = new Random();
        boolean isPlaced = false;
        while (!isPlaced) {
            int row = random.nextInt(LENGTH);
            int column = random.nextInt(LENGTH);
            boolean horizontal = random.nextBoolean();
            isPlaced = placeNewShip(row, column, horizontal, shipType);
        }
    }

    /**
     * Places new ship in ocean.
     *
     * @param row        row position.
     * @param column     column position.
     * @param horizontal horizontal disposition flag.
     * @param type       ship type enum value.
     * @return true if the place action was performed successfully.
     */
    private boolean placeNewShip(final int row, final int column, final boolean horizontal, final ShipType type) {
        Ship newShip = createNewShip(type);
        if (newShip.okToPlaceShipAt(row, column, horizontal, this)) {
            newShip.placeShipAt(row, column, horizontal, this);
            return true;
        }
        return false;
    }

    /**
     * Creates a new Ship according to received parameter.
     *
     * @param ship ship type enum value.
     * @return {@link Ship} instance.
     */
    private Ship createNewShip(final ShipType ship) {
        EnumMap<ShipType, ShipCreator> strategyMap = new EnumMap<>(ShipType.class);
        strategyMap.put(ShipType.BATTLESHIP, BattleShip::new);
        strategyMap.put(ShipType.BATTLE_CRUISER, BattleCruiser::new);
        strategyMap.put(ShipType.CRUISER, Cruiser::new);
        strategyMap.put(ShipType.LIGHT_CRUISER, LightCruiser::new);
        strategyMap.put(ShipType.DESTROYER, Destroyer::new);
        strategyMap.put(ShipType.SUBMARINE, Submarine::new);
        return strategyMap.get(ship).buildShip();
    }

    /**
     * Checks if location in ships array is occupied.
     *
     * @param row    row position.
     * @param column column position.
     * @return true of the location is occupied.
     */
    public boolean isOccupied(final int row, final int column) {
        return !(ships[row][column] instanceof EmptySea);
    }

    /**
     * Shoots at specified position.
     *
     * @param row    row position.
     * @param column column position.
     * @return true if the shoot was performed successfully.
     */
    public boolean shootAt(final int row, final int column) {
        shotsFired++;
        if (ships[row][column].shootAt(row, column)) {
            increaseHitCounters(row, column);
            return true;
        }
        return false;
    }

    /**
     * Increases the hit counters.
     *
     * @param row    row position.
     * @param column column position.
     */
    private void increaseHitCounters(final int row, final int column) {
        if (ships[row][column].isSunk()) {
            shipsSunk++;
        }
        hitCount++;
    }

    /**
     * Gets shots fired counter.
     *
     * @return shots fired counter value.
     */
    public int getShotsFired() {
        return shotsFired;
    }

    /**
     * Gets the hit count counter.
     *
     * @return git count counter value.
     */
    public int getHitCount() {
        return hitCount;
    }

    /**
     * Gets ship's sunk counter.
     *
     * @return ship's sunk counter value.
     */
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * Gets the ship's array.
     *
     * @return array of {@link Ship}.
     */
    public Ship[][] getShipArray() {
        return ships.clone();
    }

    /**
     * Checks if game is already over and completed.
     *
     * @return true if the game is over.
     */
    public boolean isGameOver() {
        return SHIPS_NUMBER == shipsSunk;
    }

    /**
     * Functional interface for create ship strategy.
     */
    interface ShipCreator {

        /**
         * Builds a new ship.
         *
         * @return {@link Ship}.
         */
        Ship buildShip();
    }

    /**
     * Enum for ship type values.
     */
    enum ShipType {
        BATTLESHIP,
        BATTLE_CRUISER,
        CRUISER,
        LIGHT_CRUISER,
        DESTROYER,
        SUBMARINE
    }
}
