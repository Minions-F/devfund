package org.minions.devfund.bruno.battleship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.util.stream.IntStream.range;

/**
 * Class to in charge that manage the ocean event.
 */
public class Ocean {
    private static final int SIZE = 20;
    private static final int TOTAL_SHIPS = 13;
    private static final String BATTLESHIP = "battleship";
    private static final String BATTLECRUISER = "battlecruiser";
    private static final String CRUISER = "cruiser";
    private static final String LIGHTCRUISER = "lightcruiser";
    private static final String DESTROYER = "destroyer";
    private static final String SUBMARINE = "submarine";
    private Ship[][] ships = new Ship[SIZE][SIZE];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    /**
     * Constructor that initializes any game variables and generates the empty ocean.
     */
    public Ocean() {
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
        generateOcean();
    }

    /**
     * Generates a empty ocean.
     */
    private void generateOcean() {
        range(0, SIZE).forEach(row -> range(0, SIZE).forEach(col -> {
            EmptySea emptySea = new EmptySea();
            emptySea.placeShipAt(row, col, true, this);
        }));
    }

    /**
     * Place all randomly on the (initially empty) ocean.
     * Place larger ships before smaller ones, or you may end up with no legal place to put a large ship.
     */
    public void placeAllShipsRandomly() {
        List<String> shipNames = Arrays.asList(BATTLESHIP, BATTLECRUISER, CRUISER, CRUISER, LIGHTCRUISER,
                LIGHTCRUISER, DESTROYER, DESTROYER, DESTROYER, SUBMARINE, SUBMARINE, SUBMARINE, SUBMARINE);
        List<Ship> shipsToGenerate = new LinkedList<>();
        shipNames.forEach(shipName -> shipsToGenerate.add(getStrategyShip(shipName)));
        shipsToGenerate.forEach(this::generateRandomly);
    }

    /**
     * Gets the ship according the ship name.
     *
     * @param shipName String ship name.
     * @return Ship object.
     */
    private Ship getStrategyShip(final String shipName) {
        Map<String, Ship> strategyShipMap = new HashMap<>();
        strategyShipMap.put(BATTLESHIP, new BattleShip());
        strategyShipMap.put(BATTLECRUISER, new BattleCruiser());
        strategyShipMap.put(CRUISER, new Cruiser());
        strategyShipMap.put(LIGHTCRUISER, new LightCruiser());
        strategyShipMap.put(DESTROYER, new Destroyer());
        strategyShipMap.put(SUBMARINE, new Submarine());
        return strategyShipMap.get(shipName);
    }

    /**
     * Generates randomly the ships.
     *
     * @param ship array ship.
     */
    private void generateRandomly(final Ship ship) {
        Random random = new Random();
        boolean flag = true;
        while (flag) {
            int row = random.nextInt(SIZE);
            int column = random.nextInt(SIZE);
            boolean horizontal = random.nextBoolean();
            if (ship.okToPlaceShipAt(row, column, horizontal, this)) {
                ship.placeShipAt(row, column, horizontal, this);
                flag = false;
            }
        }
    }

    /**
     * Returns true if the given location contains a ship, false if it does not.
     *
     * @param row    integer value.
     * @param column integer value.
     * @return boolean value.
     */
    public boolean isOccupied(final int row, final int column) {
        return !ships[row][column].getShipType().equals("empty");
    }

    /**
     * Returns true if the given location contains a real ship, still afloat, (not an EmptySea), false if it does not.
     * In addition, this method updates the number of shots that have been fired, and the number of hits.
     *
     * @param row    integer value.
     * @param column integer value.
     * @return boolean value.
     */
    public boolean shootAt(final int row, final int column) {
        shotsFired++;
        if (isOccupied(row, column)) {
            return isSunkShip(row, column);
        } else {
            ships[row][column].shootAt(row, column);
        }
        return false;
    }

    /**
     * If a location contains a real ship, shootAt should return true every time the user shoots at that same location.
     * Once a ship has been 'sunk', additional shots at its location should return false.
     *
     * @param row    integer value.
     * @param column integer value
     * @return boolean value.
     */
    private boolean isSunkShip(final int row, final int column) {
        if (ships[row][column].shootAt(row, column)) {
            if (ships[row][column].isSunk()) {
                shipsSunk++;
            }
            hitCount++;
            return true;
        }
        return false;
    }

    /**
     * Prints the ocean. To aid the user, row numbers should be displayed along the left edge of the array,
     *
     * @return the game area.
     */
    public String print() {
        return toString();
    }

    /**
     * Builds the ocean.
     *
     * @return String ocean.
     */
    public String toString() {
        StringBuilder area = new StringBuilder();
        area.append(" ");
        range(0, SIZE).mapToObj(i1 -> String.format("%3d", i1)).forEachOrdered(area::append);
        area.append("\n");
        range(0, SIZE).forEach(row -> {
            area.append(String.format("%2d ", row));
            range(0, SIZE).forEach(col ->
                    area.append(!ships[row][col].wasShootAt(row, col) ? "." : ships[row][col].toString()).append("  "));
            area.append("\n");
        });
        return area.toString();
    }

    /**
     * Gets the 20x20 array of ships. The methods in the Ship class that take an Ocean parameter really
     * need to be able to look at the contents of this array.
     * the placeShipAt method even needs to modify it.
     *
     * @return Array ships.
     */
    public Ship[][] getShipArray() {
        return ships.clone();
    }

    /**
     * Gets the number of shots fired (in this game).
     *
     * @return integer shoots fired value.
     */
    public int getShotsFired() {
        return shotsFired;
    }

    /**
     * Gets the number of hits recorded (in this game). All hits are counted,
     * not just the first time a given square is hit.
     *
     * @return integer hits count value.
     */
    public int getHitCount() {
        return hitCount;
    }

    /**
     * Gets the number of ships sunk (in this game).
     *
     * @return integer ships sunk value.
     */
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * Gets true if all ships have been sunk, otherwise false.
     *
     * @return boolean game over value.
     */
    public boolean isGameOver() {
        return shipsSunk == TOTAL_SHIPS;
    }
}
