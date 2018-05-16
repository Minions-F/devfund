package org.minions.devfund.lourdes.battleship;

public class ShipFactory {

    public Ship createShip(String sheepType) {
        if (sheepType.equals("Battleship")) {
            return new Battleship();

        } else if (sheepType.equalsIgnoreCase("BattleCruiser")) {
            return new Battlecruiser();

        } else if (sheepType.equalsIgnoreCase("Cruiser")) {
            return new Cruiser();

        } else if (sheepType.equalsIgnoreCase("LightCruiser")) {
            return new LightCruiser();

        } else if (sheepType.equals("Destroyer")) {
            return new Destroyer();
        }
        return new Submarine();
    }
}
