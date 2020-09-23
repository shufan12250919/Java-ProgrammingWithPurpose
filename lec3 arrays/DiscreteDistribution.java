/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] list = new int[args.length - 1];
        int[] sum = new int[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(args[i + 1]);
            sum[i + 1] = sum[i] + list[i];

        }
        int line = 25;
        for (int i = 0; i < m; i++) {
            int pick = (int) (Math.random() * sum[sum.length - 1]);
            for (int j = 0; j < sum.length - 1; j++) {
                if (pick >= sum[j] && pick < sum[j + 1]) {
                    if (line == 1) {
                        System.out.println(j + 1);
                        line = 25;
                    }
                    else {
                        System.out.print((j + 1) + " ");
                        line--;
                    }
                }
            }
        }

    }
}
