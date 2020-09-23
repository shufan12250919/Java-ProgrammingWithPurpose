/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int total = 0;
        long max = (long) Math.cbrt(n);
        for (long i = 1; i <= max; i++) {
            long b = (long) (Math.cbrt(n - i * i * i));
            long b2 = b + 1;
            long bQ1 = b * b * b;
            long bQ2 = b2 * b2 * b2;
            if (i * i * i + bQ1 == n) {
                total++;
            }
            else if (i * i * i + bQ2 == n) {
                total++;
            }


        }
        // System.out.println(total);
        if (total >= 4) return true;
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
