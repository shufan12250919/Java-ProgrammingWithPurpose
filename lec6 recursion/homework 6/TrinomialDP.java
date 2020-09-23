/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k > n || k < -n) return 0;
        if (n == 0 && k == 0) return 1;
        long[] list = { 1, 1, 1 };
        long[] listS = { 1, 1, 1 };
        for (int i = 2; i <= n; i++) {
            listS = new long[2 * i + 1];
            listS[0] = 1;
            listS[1] = list[1] + list[0];
            for (int j = 2; j <= i; j++) {
                listS[j] = list[j - 2] + list[j - 1] + list[j];
            }
            for (int y = listS.length - 1; y >= 0; y--) {
                listS[y] = listS[listS.length - y - 1];
            }
            list = listS;
        }
        return listS[n + k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    }
}
