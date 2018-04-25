package org.minions.devfund.sergio;

public class Squarelotron {

    private int[][] squarelotron;
    private int size;

    public Squarelotron(int n) {
        size = n;
        int num = 1;
        squarelotron = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotron[i][j] = num++;
            }
        }
    }

    public String showSquare(Squarelotron squarelotron) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (squarelotron.squarelotron[i][j] < 10) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(squarelotron.squarelotron[i][j]);
                if (j != size - 1) {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().trim();
    }

    public int getNumberOfRings() {
        return size % 2 == 0 ? size / 2 : size / 2 + 1;
    }

    public boolean ringCheck(int i, int j, int ring) {
        // Check if the current number is in the ring
        return (i == ring - 1 || j == ring - 1 || i == size - ring || j == size - ring)
                // And the current number is not outside of the ring
                && !((i <= ring - 2 || i >= size + 1 - ring || j <= ring - 2 || j >= size + 1 - ring));
    }

    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron squarelotronResult = new Squarelotron(size);
        squarelotronResult.squarelotron = upsideDownFlip(squarelotronResult.squarelotron, ring);
        return squarelotronResult;
    }

    public int[][] upsideDownFlip(int[][] squarelotronArray, int ring) {
        final int[][] auxArray = squarelotronArray.clone();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (ringCheck(i, j, ring)) {
                    squarelotronArray[i][j] = auxArray[size - 1 - i][j];
                }
            }
        }
        return squarelotronArray;
    }

    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron squarelotronResult = new Squarelotron(size);
        squarelotronResult.squarelotron = mainDiagonalFlip(squarelotronResult.squarelotron,ring);
        return squarelotronResult;
    }

    public int[][] mainDiagonalFlip(int[][] squarelotronArray, int ring) {
        final int[][] auxArray = squarelotronArray.clone();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (ringCheck(i, j, ring)) {
                    squarelotronArray[i][j] = auxArray[j][i];
                }
            }
        }
        return squarelotronArray;
    }

//    public Squarelotron rotateEast(int turns) {
//        Squarelotron squarelotronResult = new Squarelotron(size);
//        while (turns > 0) {
//            squarelotronResult.squarelotron = upsideDownFlip(squarelotronResult.squarelotron, 1);
//            squarelotronResult.squarelotron =
//            turns--;
//        }
//        return squarelotronResult;
//    }

//    public Squarelotron rotateWest(int turns) {
//        Squarelotron squarelotronResult = new Squarelotron(size);
//        while (turns < 0) {
//            squarelotronResult = mainDiagonalFlip(squarelotronResult, 1);
//            squarelotronResult = upsideDownFlip(squarelotronResult, 1);
//            turns++;
//        }
//        return squarelotronResult;
//    }

//    public void rotateRight(int numberOfTurns) {
//        if (numberOfTurns >= 0) {
//            showSquare(rotateEast(numberOfTurns));
//            return;
//        }
//        showSquare(rotateWest(numberOfTurns));
//    }
}
