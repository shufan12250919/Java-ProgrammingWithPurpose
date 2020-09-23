/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RevesPuzzle {

    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n - k == 0) return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    private static void hanoif(int n, String from, String temp1, String temp2, String to) {

        if (n == 0) return;
        if (n == 1) {
            StdOut.println("Move disc " + n + " from " + from + " to " + to);
            return;
        }
        if (n == 2) {
            StdOut.println("Move disc " + (n - 1) + " from " + from + " to " + temp1);
            StdOut.println("Move disc " + n + " from " + from + " to " + to);
            StdOut.println("Move disc " + (n - 1) + " from " + temp1 + " to " + to);
            return;
        }

        if (n == 3) {
            StdOut.println("Move disc " + (n - 2) + " from " + from + " to " + temp1);
            StdOut.println("Move disc " + (n - 1) + " from " + from + " to " + temp2);
            StdOut.println("Move disc " + n + " from " + from + " to " + to);
            StdOut.println("Move disc " + (n - 1) + " from " + temp2 + " to " + to);
            StdOut.println("Move disc " + (n - 2) + " from " + temp1 + " to " + to);
            return;
        }

        int k = (int) (n + 1 - Math.sqrt(2 * n + 1));
        // System.out.println(k);
        hanoif(k, from, to, temp2, temp1);
        hanoi(n, k, from, temp2, to);
        hanoif(k, temp1, from, temp2, to);

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        hanoif(n, "A", "B", "C", "D");
    }
}
