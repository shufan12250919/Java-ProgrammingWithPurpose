/* *****************************************************************************
 *  Name:              Shu-Fan Lin
 *  Coursera User ID:  123456
 *  Last modified:     2020/4/13
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int total = 0;  // numbers to be input
        int[] list = new int[m + 1];    // [0] represent the times number 0 appears
        while (!StdIn.isEmpty()) {
            int num = StdIn.readInt();
            list[num]++;
            total++;
        }
        double result = 0.0;
        for (int i = 1; i < list.length; i++) {
            double percent = 1.0 * list[i] / total;
            if (percent == 0) {
                result += 0;
            }
            else {
                result += (-1 * percent * (Math.log(percent) / Math.log(2)));
            }
        }
        StdOut.printf("%.4f\n", result);
    }
}
