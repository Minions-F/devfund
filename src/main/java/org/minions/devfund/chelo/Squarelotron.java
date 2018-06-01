package org.minions.devfund.chelo;

/**
 * Class Squarelotron.
 */
public class Squarelotron {

    private int[][] sArray;
    protected int size;

    /**
     * Contructor for Squarelotron.
     * @param n size of the matrix
     */
    public Squarelotron(int n) {
        this.size = n;
        this.sArray = new int[n][n];
        int counter = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.sArray[i][j] = counter;
                counter++;
            }
        }
    }

    /**
     * A method to fill the 2-dimensional array with the numbers 1 to n squared.
     * @param n size of the array
     * @return array squarelotron filled
     */
    Squarelotron initializeArray(int n) {
        Squarelotron array = new Squarelotron(n);
        int counter = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array.sArray[i][j] = counter;
                counter++;
            }
        }
        return array;
    }

    /**
     * A method to perform Upside-Down Flip of the squarelotron and returns the new squarelotron.
     * The original squarelotron should not be modified.
     * @param ring given to work on it
     * @return new Squarelotron
     */
    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron sAux = initializeArray(this.size);
        sAux = getUpsideDownFlipArray(sAux, this.sArray, ring);
        return sAux;
    }

    /**
     * This method performs the Main Diagonal Flip of the squarelotron and returns the new squarelotron.
     * @param ring the ring
     * @return new array
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron squarelotronDiagonal = initializeArray(this.size);

        int indexX = ring - 1;
        int aux;
        for (int m = ring - 1; m < this.size - ring + 1; m++) {
            aux = squarelotronDiagonal.sArray[indexX][ring - 1];
            squarelotronDiagonal.sArray[indexX][ring - 1] = this.sArray[ring - 1][m];
            squarelotronDiagonal.sArray[ring - 1][m] = aux;
            indexX++;
        }

        indexX = ring;
        for (int n = ring; n < this.size - ring; n++) {
            aux = squarelotronDiagonal.sArray[indexX][this.size - ring];
            squarelotronDiagonal.sArray[indexX][this.size - ring] = this.sArray[this.size - ring][n];
            squarelotronDiagonal.sArray[this.size - ring][n] = aux;
            indexX++;
        }

        return squarelotronDiagonal;
    }

    /**
     * This method modifies the internal representation of the squarelotron.
     * It does not create a new squarelotron.
     * @param numberOfTurns The argument numberOfTurns indicates the number of times the entire
     *                      squarelotron should be rotated 90° clockwise
     */
    public void rotateRight(int numberOfTurns) {

        final int magicTurns = 4;
        Squarelotron arrayUpsideDown = new Squarelotron(this.size);
        Squarelotron squarelotronRotate = new Squarelotron(this.size);
        Squarelotron squarelotronAux = initializeArray(this.size);
        int realTurns;

        realTurns = numberOfTurns % magicTurns + magicTurns;

        for (int turns = 1; turns <= realTurns % magicTurns; turns++) {
            for (int ring = 1; ring <= (this.size / 2) + (this.size % 2); ring++) {
                arrayUpsideDown = getUpsideDownFlipArray(arrayUpsideDown, squarelotronAux.sArray, ring);
            }

            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    squarelotronRotate.sArray[j][i] = arrayUpsideDown.sArray[i][j];
                }
            }
            squarelotronAux = squarelotronRotate;
        }
        this.sArray = squarelotronRotate.sArray;
    }

    /**
     * A method to upside down flip.
     * @param arrayResult the resultant array
     * @param array the given array
     * @param ring the ring
     * @return new array flipped
     */
    Squarelotron getUpsideDownFlipArray(final Squarelotron arrayResult, final int[][] array, int ring) {
        int indexX;
        int indexY;

        indexX = ring - 1;
        for (int m = ring - 1; m < this.size - ring + 1; m++) {
            arrayResult.sArray[this.size - ring][indexX] = array[ring - 1][m];
            indexX++;
        }

        indexX = ring - 1;
        indexY = ring - 1;
        for (int n = ring - 1; n < this.size - ring + 1; n++) {
            arrayResult.sArray[indexX][indexY] = array[this.size - ring][n];
            indexY++;
        }

        indexX = this.size - ring - 1;
        indexY = ring - 1;
        for (int j = ring; j < this.size - ring; j++) {
            arrayResult.sArray[indexX][indexY] = array[j][ring - 1];
            indexX--;
        }

        indexX = this.size - ring - 1;
        indexY = this.size - ring;
        for (int k = ring; k < this.size - ring; k++) {
            arrayResult.sArray[indexX][indexY] = array[k][this.size - ring];
            indexX--;
        }
        return arrayResult;
    }

    /**
     * A method to print the squarelotron content.
     * @param array squarelotron
     */
    void getArray(final Squarelotron array) {
        for (int i = 0; i < array.sArray.length; i++) {
            for (int j = 0; j < array.sArray.length; j++) {
                System.out.print("[" + array.sArray[i][j] + "]");
            }
            System.out.println(" ");
        }
    }

    /**
     * Method to return squarelotron array.
     * @return array
     */
    public int[][] getSquarelotron() {
        int[][] aux = sArray;
        return aux;
    }

    /**
     * Main method.
     * @param args main
     */
    public static void main(final String[] args) {
        final int majicSize = 6;
        Squarelotron squarelotron = new Squarelotron(majicSize);
        System.out.println("--- Original squarelotron ---");
        squarelotron.getArray(squarelotron);
        System.out.println("--- Upside Down Flip--- ");
        squarelotron.getArray(squarelotron.upsideDownFlip(1));
        System.out.println("--- Main Diagonal Flip ---");
        squarelotron.getArray(squarelotron.mainDiagonalFlip(1));
        System.out.println("--- Rotate ---");
        squarelotron.rotateRight(1);
        squarelotron.getArray(squarelotron);
    }
}
