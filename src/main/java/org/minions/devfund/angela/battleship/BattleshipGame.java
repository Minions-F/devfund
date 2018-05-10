package org.minions.devfund.angela.battleship;

import java.util.Scanner;

/**
 * Executes Battleship game.
 */
public final class BattleshipGame {

    /**
     * Private constructor.
     */
    private BattleshipGame() {

    }

    /**
     * Executes the game.
     *
     * @param args args.
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in, "UTF-8");
        Ocean ocean = new Ocean();
        System.out.println("Welcome to BattleShip Game! \n");
        ocean.placeAllShipsRandomly();
        String input = "";
        while (!input.equals("q") && !ocean.isGameOver()) {
            System.out.println("Shot fired: " + ocean.getShotsFired());
            System.out.println("Hits: " + ocean.getHitCount());
            System.out.println("Ships sunk: " + ocean.getShipsSunk());
            System.out.println();
            ocean.print();

            System.out.print("5 places to shoot at: ");
            input = scanner.nextLine();
            String[] pairs = input.split("; ");
            for (String pair : pairs) {
                String[] locations = pair.split(", ");
                if (ocean.shootAt(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]))) {
                    System.out.println("hit");
                } else {
                    System.out.println("miss");
                }
            }
        }
        System.out.print("Game over!");
    }
}
