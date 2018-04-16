package org.minions.devfund.dennis;

import java.util.Scanner;

/**
 * This Class start the game for WhackAMole.
 */
class MainMole {

    /**
     * Constructor.
     */
    protected MainMole() { }

    /**
     * Main WhackAMole Game.
     * @param args dafault values
     */
    public static void main(final String[] args) {
        final int attemptsNumber = 10;
        final int boardDimension = 10;
        final int maxPosition = 9;
        final int randomMole = 10;
        final int molesInGrid = 9;

        int positionX;
        int positionY;


        Scanner scanner = new Scanner(System.in, "UTF-8");
        WhackAMole rungame = new WhackAMole(attemptsNumber, boardDimension);

        System.out.println("\t");
        System.out.println("---------------WhackAMole Game---------------");
        System.out.println("\t");
        rungame.printGridToUser();
        System.out.println("\t");
        System.out.println("-------------------------------------------------------------");
        System.out.println("\t");

        while (rungame.getMolesLeft() < molesInGrid) {
            double value = Math.random() * randomMole;
            double value2 = Math.random() * randomMole;
            int randomX = (int) value;
            int randomY = (int) value2;
            rungame.place(randomX, randomY);
        }
        rungame.results();
        while (rungame.getAttempts() > 0) {
            System.out.println("\t");
            System.out.println("-------------------------------------------------------------");
            System.out.println("Enter value for position X (0-9): ");
            positionX = scanner.nextInt();
            System.out.println("Enter value for position Y  (0-9): ");
            positionY = scanner.nextInt();
            if (positionX < 0 || positionX > maxPosition) {
                System.out.println("Invalid number for position X: " + positionX);
                System.out.println("Restart the game");
                break;
            } else {
                if (positionY < 0 || positionY > maxPosition) {
                    System.out.println("Invalid number for position X: " + positionY);
                    System.out.println("Restart the game");
                    break;
                } else {
                    rungame.whack(positionX, positionY);
                    System.out.println("-------------------------------------------------------------");
                    rungame.results();
                    System.out.println("-------------------------------------------------------------");
                }
            }
        }
        System.out.println("-------------------------------------------------------------");
        rungame.printGrid();
        System.out.println("-------------------------------------------------------------");
        System.out.println("-----Your final Score is: " + rungame.getScore());
        System.out.println("-------------------------------------------------------------");
    }
}
