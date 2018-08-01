package org.minions.devfund.lourdes.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Implemented tests for {@link ShipFactory}.
 */
public class ShipFactoryTest {
    private ShipFactory shipFactory;

    /**
     * Method that setup initial values.
     */
    @Before
    public void setup() {
        shipFactory = new ShipFactory();
    }

    /**
     * Verify created object is a BattleShip.
     */
    @Test
    public void testCreateBattleShip() {
        final String shipType = "BattleShip";
        assertEquals(shipType.toLowerCase(), shipFactory.createShip(shipType).getShipType());
    }

    /**
     * Verify created object is a BattleCruiser.
     */
    @Test
    public void testCreateBattleCruiser() {
        final String shipType = "BattleCruiser";
        assertEquals(shipType.toLowerCase(), shipFactory.createShip(shipType).getShipType());
    }

    /**
     * Verify created object is a Cruiser.
     */
    @Test
    public void testCreateCruiser() {
        final String shipType = "Cruiser";
        assertEquals(shipType.toLowerCase(), shipFactory.createShip(shipType).getShipType());
    }

    /**
     * Verify created object is a LightCruiser.
     */
    @Test
    public void testCreateLightCruiser() {
        final String shipType = "LightCruiser";
        assertEquals(shipType.toLowerCase(), shipFactory.createShip(shipType).getShipType());
    }

    /**
     * Verify created object is a Destroyer.
     */
    @Test
    public void testCreateDestroyer() {
        final String shipType = "Destroyer";
        assertEquals(shipType.toLowerCase(), shipFactory.createShip(shipType).getShipType());
    }

    /**
     * Verify created object is a Submarine.
     */
    @Test
    public void testCreateSubmarine() {
        final String shipType = "Submarine";
        assertEquals(shipType.toLowerCase(), shipFactory.createShip(shipType).getShipType());
    }
}
