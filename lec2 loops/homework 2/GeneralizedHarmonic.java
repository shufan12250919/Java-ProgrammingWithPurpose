/* *****************************************************************************
 *  Name:              Shu-Fan Lin
 *  Last modified:     11, 04, 2020
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int base = Integer.parseInt(args[0]);
        int exp = Integer.parseInt(args[1]);
        double result = 0.0;
        for (int i = 1; i <= base; i++) {
            double denominator = Math.pow(i, exp);
            double number = 1.0 / denominator;
            result += number;
        }
        System.out.println(result);
    }
}
