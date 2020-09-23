/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long invert = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[i]) invert++;
            }
        }
        return invert;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i;
        }
        int max = n - 1;    // the last index of array
        int now = max;      // use to trace the number need to move
        int end = 0;        // check if we need to move another number
        for (int i = 0; i < k; i++) {
            // System.out.println("yes");
            int temp = list[now];
            list[now] = list[now - 1];
            list[now - 1] = temp;
            now--;
            if (now == end) {
                now = max;
                end++;
            }
        }
        return list;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Integer.parseInt(args[1]);
        int[] inversion = generate(n, k);
        for (int i = 0; i < inversion.length; i++) {
            System.out.print(inversion[i] + " ");
        }
    }
}
