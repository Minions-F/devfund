package org.minions.devfund.yuri;

import java.util.Random;

/**
 * This class represents the WackAMole game.
 */
public final class WhackAMole {

  public static final char MOLE = 'M';
  public static final char WACKED = 'W';
  public static final char EMPTYCELL = '*';
  public static final int MOLES_AMOUNT = 10;
  public static final int INITIAL_SCORE = 0;
  public static final int ONE = 1;
  private int score;
  private int molesLeft;
  private int attemptsLeft;
  private int dimension;
  private char[][] grid;

  /**
   * Constructor Method.
   * @param numAttempts number of attempts for the player.
   * @param gridDimension the size of the moleGrid.
   */
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
   * @return <code>true</code> if it is possible to place the mole;
   *         <code>false</code> if it is not.
   */
  public boolean place(final int posX, final int posY) {
    boolean flag = false;
    if (isEmptyCell(posX, posY)) {
      grid[posX][posY] = MOLE;
      flag = true;
    }
    return flag;
  }

  /**
   * It is in charge to insert Moles to moleGrid.
    */
  public void insertMoles() {
    int accumulator = 0;
    while (accumulator < MOLES_AMOUNT) {
      if (place(getRandomNumber(), getRandomNumber())) {
        accumulator++;
      }
    }
  }

  /**
   * It is charge to perform Whack in a specific position.
   * @param posX coordinate X on moleGrid.
   * @param posY coordinate Y on moleGrid.
   */
  public void whack(final int posX, final int posY) {
    if (isMole(posX, posY)) {
      increaseScore();
      decreaseAttemptsLeft();
      decreaseMolesLeft();
    } else {
      decreaseAttemptsLeft();
    }
    grid[posX][posY] = WACKED;
  }

  /**
   * It is in charge to verify if the cell is empty.
   * @param posX coordinate X on moleGrid.
   * @param posY coordinate Y on moleGrid.
   * @return <code>true</code> if it is an empty cell;
   *         <code>false</code> if it is not.
   */
  public boolean isEmptyCell(final int posX, final int posY) {
    return grid[posX][posY] == EMPTYCELL;
  }

  /**
   * It is in charge to verify if the cell has a mole.
   * @param posX coordinate X on moleGrid.
   * @param posY coordinate Y on moleGrid.
   * @return <code>true</code> if there is a mole ;
   *         <code>false</code> if it is not.
   */
  public boolean isMole(final int posX, final int posY) {
    return grid[posX][posY] == MOLE;
  }

  /**
   * This method initialize the moleGrid with empty values.
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
   * Prints the Grid without showing where the moles are.
   */
  public void printGridToUser() {
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        if (grid[row][column] == MOLE) {
          System.out.print(String.format("%c ", EMPTYCELL));
        } else {
          System.out.print(String.format("%c ", grid[row][column]));
        }
      }
      System.out.print("\n");
    }
  }

  /**
   * It is in charge to get the moleGrid dimension.
   * @return  moleGrid dimension.
   */
  public int getDimension() {
    return dimension;
  }

  /**
   * It ins charge to get the moleGrid.
   * @return the moleGrid matrix.
   */
  public char[][] getGrid() {
    char[][] gridGame = this.grid;
    return gridGame;
  }

  /**
   * Prints the moleGrid completely.
   */
  public void printGrid() {
    for (int row = 0; row < grid.length; row++) {
      for (int column = 0; column < grid[row].length; column++) {
        System.out.print(String.format("%c ", grid[row][column]));
      }
      System.out.print("\n");
    }
  }

  /**
   * It is in charge to get player score.
   * @return the player score.
   */
  public int getScore() {
    return score;
  }

  /**
   * It is in charge to increase the player score.
   */
  public void increaseScore() {
    score = score + ONE;
  }

  /**
   * It is in charge to get the moles left amount.
   * @return moles left amount.
   */
  public int getMolesLeft() {
    return molesLeft;
  }

  /**
   * It is in charge to decrease the moles left amount.
   */
  public void decreaseMolesLeft() {
    molesLeft = molesLeft - ONE;
  }

  /**
   * It is in charge to get the player attempts left amount.
   * @return player attempts left amount.
   */
  public int getAttemptsLeft() {
    return attemptsLeft;
  }

  /**
   * It is in charge to decrease the player attempts left amount.
   */
  public void decreaseAttemptsLeft() {
    attemptsLeft = attemptsLeft - ONE;
  }

  /**
   * It is in charge to verify if the player won.
   * @return <code>true</code> if the player won ;
   *         <code>false</code> if it is not.
   */
  public boolean playerWin() {
    return molesLeft == 0;
  }

  /**
   * It is in charge to verify if the player lose.
   * @return <code>true</code> if the player lose ;
   *         <code>false</code> if it is not.
   */
  public boolean playerLose() {
    return attemptsLeft == 0;
  }
}
