package org.minions.devfund.lourdes.battleship;

public class BattleshipGame {
    public static void main(String[] arg){
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        ocean.print();

    }
}
