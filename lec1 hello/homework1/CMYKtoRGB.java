/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class CMYKtoRGB {
    public static void main(String[] args) {
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);
        double white = 1.0 - black;
        double red1 = 255 * white * (1 - cyan);
        double green1 = 255 * white * (1 - magenta);
        double blue1 = 255 * white * (1 - yellow);
        int red = (int) Math.round(red1);
        int green = (int) Math.round(green1);
        int blue = (int) Math.round(blue1);
        System.out.println("red   = " + red);
        System.out.println("green = " + green);
        System.out.println("blue  = " + blue);
    }
}
