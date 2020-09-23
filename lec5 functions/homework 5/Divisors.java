/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Divisors {
    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        if (a == 0 && b == 0) return 0;
        int absA = Math.max(Math.abs(a), Math.abs(b));
        int absB = Math.min(Math.abs(a), Math.abs(b));
        if (absB == 0) return absA;
        int first = absB;
        int remain = absA % absB;
        while (remain != 0) {
            int temp = remain;
            remain = first % remain;
            first = temp;
        }
        return first;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        return absA / gcd(a, b) * absB;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        if (gcd(a, b) == 1) {
            return true;
        }
        return false;

    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int total = 0;
        if (n == 1) return 1;
        for (int i = 1; i < n; i++) {
            if (areRelativelyPrime(i, n)) {
                total++;
            }
        }
        return total;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        StdOut.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        StdOut.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        StdOut.println("totient(" + a + ") = " + totient(a));
        StdOut.println("totient(" + b + ") = " + totient(b));


    }
}
