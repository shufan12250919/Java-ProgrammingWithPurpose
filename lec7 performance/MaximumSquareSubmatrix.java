/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int[][] possible = new int[a.length][a.length];
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            possible[i][0] = a[i][0];
            possible[0][i] = a[0][i];
            if (a[i][0] == 1 || a[0][i] == 1) max = 1;
        }

        for (int i = 1; i < a.length;
             i++) {    // check from the bottom-right courner for biggest square
            for (int j = 1; j < a.length; j++) {
                if (a[i][j] == 1) {
                    int up = Math.min(possible[i - 1][j - 1], possible[i - 1][j]);
                    possible[i][j] = Math.min(possible[i][j - 1], up)
                            + 1; // + 1 is for at least for 1*1 square
                    if (max < possible[i][j]) {
                        max = possible[i][j];
                    }
                }
                else {
                    possible[i][j] = 0;
                }
            }
        }

        return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int size = StdIn.readInt();
        int[][] a = new int[size][size];
        while (!StdIn.isEmpty()) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    a[i][j] = StdIn.readInt();
                }
            }
        }
        System.out.println(size(a));

    }
}
