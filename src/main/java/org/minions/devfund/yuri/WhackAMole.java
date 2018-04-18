package org.minions.devfund.yuri;

import java.util.Random;

/**
 * This class represents the WackAMole game.
 */
public final class WhackAMole {

  public static final char MOLE = 'M';
  public static final char WACKED = 'W';
  public static final char EMPTYCELL = '*';
  private int score;
  private int molesLeft;
  private int attemptsLeft;
  private int dimension;
  private char[][] moleGrid;

  /**
   * Constructor Method.
   * @param numAttempts number of attempts for the player.
   * @param gridDimension the size of the moleGrid.
   */
  public WhackAMole(final int numAttempts, final int gridDimension) {
    dimension = gridDimension;
    attemptsLeft = numAttempts;
    molesLeft = 0;
    score = 0;
    moleGrid = new char[gridDimension][gridDimension];
    fillGrid();
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
      moleGrid[posX][posY] = MOLE;
      flag = true;
      molesLeft++;
    }
    return flag;
  }

  /**
   * It is in charge to insert Moles to moleGrid.
   * @param molesAmount moles amount.
   */
  public void insertMoles(final int molesAmount) {
    while (molesLeft < molesAmount) {
      place(getRandomNumber(), getRandomNumber());
    }
  }

  /**
   * It is charge to perform Whack in a specific position.
   * @param posX coordinate X on moleGrid.
   * @param posY coordinate Y on moleGrid.
   */
  public void whack(final int posX, final int posY) {
    if (isMole(posX, posY)) {
      score++;
      molesLeft--;
    }
    attemptsLeft--;
    moleGrid[posX][posY] = WACKED;
  }

  /**
   * It is in charge to verify if the cell is empty.
   * @param posX coordinate X on moleGrid.
   * @param posY coordinate Y on moleGrid.
   * @return <code>true</code> if it is an empty cell;
   *         <code>false</code> if it is not.
   */
  public boolean isEmptyCell(final int posX, final int posY) {
    return moleGrid[posX][posY] == EMPTYCELL;
  }

  /**
   * It is in charge to verify if the cell has a mole.
   * @param posX coordinate X on moleGrid.
   * @param posY coordinate Y on moleGrid.
   * @return <code>true</code> if there is a mole ;
   *         <code>false</code> if it is not.
   */
  public boolean isMole(final int posX, final int posY) {
    return moleGrid[posX][posY] == MOLE;
  }

  /**
   * This method initialize the moleGrid with empty values.
   */
  public void fillGrid() {
    for (int row = 0; row < moleGrid.length; row++) {
      for (int column = 0; column < moleGrid[row].length; column++) {
        moleGrid[row][column] = EMPTYCELL;
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
   * Gets the Grid without showing where the moles are.
   * @return the grid.
   */
  public String printGridToUser() {
    final StringBuilder stringBuilder = new StringBuilder();
    for (int row = 0; row < moleGrid.length; row++) {
      for (int column = 0; column < moleGrid[row].length; column++) {
        if (moleGrid[row][column] == MOLE) {
          stringBuilder.append(String.format("%c ", EMPTYCELL));
        } else {
          stringBuilder.append(String.format("%c ", moleGrid[row][column]));
        }
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }
  /**
   * Gets the moleGrid completely.
   * @return the grid.
   */
  public String printGrid() {
    final StringBuilder stringBuilder = new StringBuilder();
    for (int row = 0; row < moleGrid.length; row++) {
      for (int column = 0; column < moleGrid[row].length; column++) {
        stringBuilder.append(String.format("%c ", moleGrid[row][column]));
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }
  /**
   * It is in charge to get the moleGrid dimension.
   * @return  moleGrid dimension.
   */
  public int getDimension() {
    return dimension;
  }

  /**
   * It is in charge to get the player score..
   * @return  score.
   */
  public int getScore() {
    return score;
  }

  /**
   * It ins charge to get the moleGrid.
   * @return the moleGrid matrix.
   */
  public char[][] getMoleGrid() {
    return moleGrid.clone();
  }
  /**
   * It is in charge to get the moles left amount.
   * @return moles left amount.
   */
  public int getMolesLeft() {
    return molesLeft;
  }
  /**
   * It is in charge to get the player attempts left amount.
   * @return player attempts left amount.
   */
  public int getAttemptsLeft() {
    return attemptsLeft;
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
  public boolean noAttempts() {
    return attemptsLeft == 0;
  }
}
