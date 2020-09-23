/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int size = n;
        int power = 2;
        while (true) {
            if (size > power) {
                power *= 2;
            }
            else {
                size = power;
                break;
            }
        }

        int[] thueMorse = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                thueMorse[i] = 0;
            }
            else if (i % 2 == 0) {
                thueMorse[i] = thueMorse[i / 2];
            }
            else {
                thueMorse[i] = 1 - thueMorse[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thueMorse[i] == thueMorse[j]) {
                    System.out.print("+  ");
                }
                else {
                    System.out.print("-  ");
                }
            }
            System.out.println("");
        }

    }
}
