package org.minions.devfund.lourdes.battleship;

public class ShipFactory {

    public Ship createShip(String sheepType) {
        if (sheepType.equals("Battleship")) {
            return new Battleship();

        } else if (sheepType.equals("BattleCruiser")){
            return new Battlecruiser();

        } else if (sheepType.equals("Cruiser")){
            return new Cruiser();

        } else if (sheepType.equals("LightCruiser")){
            return new LightCruiser();

        } else if (sheepType.equals("Destroyer")) {
            return new Destroyer();
        }
        return new Submarine();
    }
}
