package org.minions.devfund.lourdes.battleship;

import java.util.Arrays;
import java.util.Scanner;

public class BattleshipGame {

    public static void main(String[] args){
        Scanner shootsInput = new Scanner(System.in);
        Ocean ocean = new Ocean();
        ocean.placeAllShipsRandomly();
        ocean.print();
//        while(!ocean.isGameOver()){
//            System.out.println("Insert shots:");
//            String shoots = shootsInput.nextLine();
//            makeShoots(shoots, ocean);
//
//            ocean.print();
//
//        }


    }
    public static void makeShoots(String shoots, Ocean ocean){
        String[] arrayShoots = shoots.split(";");
        Arrays.stream(arrayShoots).forEach((String shoot) -> ocean.shootAt(Integer.parseInt(shoot.split(",")[0]), Integer.parseInt(shoot.split(",")[1])));

    }
}
