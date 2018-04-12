package org.minions.devfund.yuri;

import java.util.Scanner;

/**
 * It is in charge to run the WhackAMole game.
 */
final class WhackAMoleApp {

    public static final int GRID_DIMENSION = 10;
    public static final int NUM_ATTEMPTS = 50;

    /**
     * Constructor Method.
     */
    private WhackAMoleApp() { }

    /**
     * It is in charge to execute the game.
     * @param args arguments.
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        WhackAMole whackAMoleGame = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);
        boolean givingUp = false;
        while (!givingUp && !whackAMoleGame.playerWin() && !whackAMoleGame.playerLose()) {
            whackAMoleGame.printGrid();
            System.out.println("==================================================");
            System.out.println("Type X = -1 and Y = -1 to exit of WackAMole Game");
            System.out.println(String.format("Type the position X , between 0 - %d :",
                    whackAMoleGame.getDimension() - 1));
            int posX = scanner.nextInt();
            System.out.println(String.format("Type the position Y , between 0 - %d :",
                    whackAMoleGame.getDimension() - 1));
            int posY = scanner.nextInt();
            if (posX == -1 || posY == -1) {
                givingUp = true;
            } else {
                whackAMoleGame.whack(posX, posY);
                System.out.println("==================================================");
                whackAMoleGame.printGridToUser();
                System.out.println("==================================================");
            }
        }
    }
}
