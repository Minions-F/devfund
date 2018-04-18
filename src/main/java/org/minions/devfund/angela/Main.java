package org.minions.devfund.angela;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

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
        final Logger logger = Logger.getLogger(Main.class.getName());
        final Scanner scanner = new Scanner(System.in, "UTF-8");

        final int numAttempts = 101;
        final int gridDimension = 10;
        final int molesQuantity = 10;

        final WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        final Random randomX = new Random();
        final Random randomY = new Random();

        while (whackAMole.getMolesLeft() < molesQuantity) {
            whackAMole.place(randomX.nextInt(gridDimension), randomY.nextInt(gridDimension));
        }

        while (whackAMole.getAttempts() > 0 && whackAMole.getMolesLeft() != 0) {
            logger.info("Where do you want to whack?");
            logger.info("X:");
            int x = scanner.nextInt();
            logger.info("Y:");
            int y = scanner.nextInt();
            if (x == -1 && y == -1) {
                System.out.println(whackAMole.printGridToUser());
                logger.info("Game over");
                break;
            }
            whackAMole.whack(x, y);
            logger.info("You have " + whackAMole.getAttempts() + " attempts");
        }

        if (whackAMole.getMolesLeft() == 0) {
            logger.info("You won!");
            System.out.println(whackAMole.printGrid());
        }

        if (whackAMole.getAttempts() == 0) {
            logger.info("Game over");
        }

        logger.info("Score: " + whackAMole.getScore());
    }
}
