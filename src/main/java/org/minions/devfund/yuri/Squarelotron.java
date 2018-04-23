package org.minions.devfund.yuri;

/**
 * Represents the squarelotron with all functionality.
 */
public class Squarelotron {
    private int[][] squarelotron;
    private int size;

    /**
     * Constructor Method.
     * @param size matrix size.
     */
    public Squarelotron(final int size) {
        squarelotron = new int[size][size];
        this.size = size;
        fillSquarelotron();
    }

    /**
     * Gets the squarelotron matrix.
     *
     * @return squarelotron matrix.
     */
    public int[][] getSquarelotron() {
        return squarelotron.clone();
    }

    /**
     * Gets the squarelotron size.
     *
     * @return size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Fills the squarelotron elements.
     */
    public void fillSquarelotron() {
        int accumalator = 1;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                    squarelotron[row][column] = accumalator++;
            }
        }
    }
}
