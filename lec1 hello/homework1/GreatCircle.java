/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double first = Math.sin((x2 - x1) / 2) * Math.sin((x2 - x1) / 2);
        double second = Math.cos(x1) * Math.cos(x2) * Math.sin((y2 - y1) / 2) * Math
                .sin((y2 - y1) / 2);
        double third = 2 * 6371.0;
        double distance = third * Math.asin(Math.sqrt(first + second));
        System.out.println(distance + " kilometers");

    }
}
