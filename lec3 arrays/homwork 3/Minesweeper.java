/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        int[][] field = new int[m + 2][n
                + 2];    // use +1 to store extra element for checking 3*3 elememnts
        for (int i = 0; i < k; i++) {
            int row = (int) (Math.random() * m + 1);
            int col = (int) (Math.random() * n + 1);
            if (field[row][col] == -1) {    // if already have mine, do the assignment again
                i--;
            }
            field[row][col] = -1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int bomb = 0;
                if (field[i][j] == -1) {    // check if the element is a bomb
                    continue;
                }
                if (field[i - 1][j - 1] == -1) {
                    bomb++;
                }
                if (field[i - 1][j] == -1) {
                    bomb++;
                }
                if (field[i - 1][j + 1] == -1) {
                    bomb++;
                }
                if (field[i][j - 1] == -1) {
                    bomb++;
                }
                if (field[i][j + 1] == -1) {
                    bomb++;
                }
                if (field[i + 1][j - 1] == -1) {
                    bomb++;
                }
                if (field[i + 1][j] == -1) {
                    bomb++;
                }
                if (field[i + 1][j + 1] == -1) {
                    bomb++;
                }
                field[i][j] = bomb;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (field[i][j] == -1) {
                    System.out.print("*  ");
                }
                else {
                    System.out.print(field[i][j] + "  ");
                }
            }
            System.out.println("");
        }


    }
}
