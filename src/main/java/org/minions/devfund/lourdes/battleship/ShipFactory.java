package org.minions.devfund.lourdes.battleship;

/**
 * Class that in charge to create the Ships.
 */
class ShipFactory {

    /**
     * Method that given the ship type create the same.
     *
     * @param shipType represents the ship type.
     * @return a new Ship according the ship type.
     */
    Ship createShip(String shipType) {
        switch (shipType) {
            case "BattleShip":
                return new BattleShip();

            case "BattleCruiser":
                return new BattleCruiser();

            case "Cruiser":
                return new Cruiser();

            case "LightCruiser":
                return new LightCruiser();

            case "Destroyer":
                return new Destroyer();
            default:
                return new Submarine();
        }
    }
}
