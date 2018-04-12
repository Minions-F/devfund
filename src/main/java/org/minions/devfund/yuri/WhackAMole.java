package org.minions.devfund.yuri;

import java.util.Random;
import java.util.Scanner;

/**
 * This class represents the wackamole game.
 */
public final class WhackAMole {

  public static final char MOLE = 'M';
  public static final char WACKED = 'W';
  public static final char EMPTYCELL = '*';
  public static final int MOLES_AMOUNT = 1;
  public static final int INITIAL_SCORE = 0;
  public static final int ONE = 1;
  public static final int EXIT_GAME = -1;
  private int score;
  private int molesLeft;
  private int attemptsLeft;
  private int dimension;
  private char[][] grid;

  public WhackAMole(final int numAttempts, final int gridDimension) {
    dimension = gridDimension;
    attemptsLeft = numAttempts;
    molesLeft = MOLES_AMOUNT;
    score = INITIAL_SCORE;
    grid = new char[gridDimension][gridDimension];
    fillGrid();
    insertMoles();
  }

  /**
   * Places the mole at that location.
   *
   * @param posX position X.
   * @param posY position Y.
   * @return
   */
  public boolean place(final int posX, final int posY) {
    boolean flag = false;
    if (isEmptyCell(posX, posY)) {
      grid[posX][posY] = MOLE;
      flag = true;
    }
    return flag;
  }

  public void insertMoles() {
    int accumulator = 0;
    while (accumulator < MOLES_AMOUNT) {
      if (place(getRandomNumber(), getRandomNumber())) {
        accumulator++;
      }
    }
  }

  public void whack(final int posX, final int posY) {
    grid[posX][posY] = WACKED;
    if (isMole(posX, posY)) {
      increaseScore();
      decreaseAttemptsLeft();
      decreaseMolesLeft();
    } else {
      decreaseAttemptsLeft();
    }
  }

  /**
   * @param posX
   * @param posY
   * @return
   */
  public boolean isEmptyCell(final int posX, final int posY) {
    return grid[posX][posY] == EMPTYCELL;
  }

  /**
   * @param posX
   * @param posY
   * @return
   */
  public boolean isMole(final int posX, final int posY) {
    return grid[posX][posY] == MOLE;
  }

  /**
   * This method initialize the grid with empty values.
   */
  public void fillGrid() {
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        grid[row][column] = EMPTYCELL;
      }
    }
  }

  /**
   * Get a a random value in range from 0 to dimension value configured.
   *
   * @return the random value.
   */
  public int getRandomNumber() {
    return new Random().nextInt(dimension);
  }

  /**
   * Print the Grid without showing where the moles are.
   */
  public void printGridToUser() {
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        if (grid[row][column] == 'M') {
          System.out.print(String.format("%c ", EMPTYCELL));
        } else {
          System.out.print(String.format("%c ", grid[row][column]));
        }
      }
      System.out.print("\n");
    }
  }

  public int getDimension() {
    return dimension;
  }

  public char[][] getGrid() {
    return grid;
  }

  /**
   * Prints the grid completely.
   */
  public void printGrid() {
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        System.out.print(String.format("%c ", grid[row][column]));
      }
      System.out.print("\n");
    }
  }

  public int getScore() {
    return score;
  }

  public void increaseScore() {
    score = score + ONE;
  }

  public int getMolesLeft() {
    return molesLeft;
  }

  public void decreaseMolesLeft() {
    molesLeft = molesLeft - ONE;
  }

  public int getAttemptsLeft() {
    return attemptsLeft;
  }

  public void decreaseAttemptsLeft() {
    attemptsLeft = attemptsLeft - ONE;
  }

  public boolean isGivingUp(int posX, int posY) {
    return posX == -1 || posY == -1;
  }

  public boolean playerWin() {
    return molesLeft == 0;
  }

  public boolean playerLose() {
    return attemptsLeft == 0;
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    WhackAMole game = new WhackAMole(50, 10);
    boolean givingUp = false;
    while (!givingUp && !game.playerWin() && !game.playerLose()) {
      game.printGrid();
      System.out.println("==================================================");
      System.out.println("Type X = -1 and Y = -1 to exit of WackAMole Game");
      System.out.println(String.format("Type the position X , between 0 - %d :", game.dimension - 1));
      int posX = scanner.nextInt();
      System.out.println(String.format("Type the position Y , between 0 - %d :", game.dimension - 1));
      int posY = scanner.nextInt();
      if (posX == -1 || posY == -1) {
        givingUp = true;
      } else {
        game.whack(posX, posY);
        System.out.println("==================================================");
        game.printGridToUser();
        System.out.println("==================================================");
      }
    }
  }
}
