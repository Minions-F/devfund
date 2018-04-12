package org.minions.devfund.aldo;

import java.util.ArrayList;
import java.util.List;

class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private int gridDimension;
    private int moles;

    private char[][] moleGrid;
    //List<LocationMoles> locationMolesList;

    WhackAMole(int numAttempts, int gridDimension) {
        score = 0;
        moles = gridDimension;
        molesLeft = gridDimension;
        attemptsLeft = numAttempts;
        this.gridDimension = gridDimension;
        moleGrid = new char[gridDimension][gridDimension];
        fillGrid();
    }

    private void fillGrid() {
        for (int column = 0; column < gridDimension; column++) {
            for (int row = 0; row < gridDimension; row++) {
                moleGrid[column][row] = '*';
            }
        }
    }

    void printGridToUser() {
        for (int column = 0; column < gridDimension; column++) {
            for (int row = 0; row < gridDimension; row++) {
                if(moleGrid[column][row] == 'M'){
                    System.out.print("*");
                } else{
                    System.out.print(moleGrid[column][row]);
                }
            }
            System.out.println();
        }
    }

    void printGrid() {
        for (int column = 0; column < gridDimension; column++) {
            for (int row = 0; row < gridDimension; row++) {
                System.out.print(moleGrid[column][row]);
            }
            System.out.println();
        }
    }

    boolean place(int x, int y) {
        if (moleGrid[x][y] == '*' && moles > 0) {
            moleGrid[x][y] = 'M';
            moles--;
            return true;
        }
        return false;
    }

    void whack(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            score += 10;
            attemptsLeft--;
            molesLeft--;
            moleGrid[x][y] = 'W';
        } else{
            attemptsLeft--;
        }

    }

    public int getScore() {
        return score;
    }

    public int getMolesLeft() {
        return molesLeft;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}
