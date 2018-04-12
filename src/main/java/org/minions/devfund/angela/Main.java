package org.minions.devfund.angela;

import java.util.Random;
import java.util.Scanner;

/**
 * Manages execution.
 */
public final class Main {

    /**
     * Avoid constructor.
     */
    private Main() {
    }

    /**
     * Executes the whack a mole game.
     *
     * @param args arguments to execute main.
     */
    public static void main(final String[] args) {
        final int numAttempts = 50;
        final int gridDimension = 10;
        final WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        Random randomI = new Random();
        Random randomJ = new Random();
        final int molesQuantity = 10;
        for (int i = 0; i < molesQuantity; i++) {
            if (!whackAMole.place(randomI.nextInt(gridDimension), randomJ.nextInt(gridDimension))) {
                i--;
            }
        }
        for (int i = 0; i < numAttempts; i++) {
            System.out.println("Where do you want to whack?");
            final Scanner scanner = new Scanner(System.in, "UTF-8");
            System.out.println("X:");
            int x = scanner.nextInt();
            System.out.println("Y:");
            int y = scanner.nextInt();
            if (x == -1 && y == -1) {
                whackAMole.printGridToUser();
                System.out.println("Game over");
                break;
            }
            whackAMole.whack(x, y);
            System.out.println(String.format("You have %s attempts", whackAMole.getAttempts()));
            if (whackAMole.getMolesLeft() == 0) {
                System.out.println("You won");
                whackAMole.printGrid();
                break;
            }
        }
        if (whackAMole.getAttempts() == 0) {
            System.out.println("Game over");
        }
        System.out.println("Score: " + whackAMole.getScore());
    }
}
