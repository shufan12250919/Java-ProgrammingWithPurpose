/* *****************************************************************************
 *  Name:              Shu-Fan Lin
 *  Coursera User ID:
 *  Last modified:     2020/4/13
 **************************************************************************** */

public class Checkerboard {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        StdDraw.setScale(0, size);
        boolean colorB = true;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                colorB = false;
            }
            else {
                colorB = true;
            }
            for (int j = 0; j < size; j++) {
                if (!colorB) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    colorB = true;
                }
                else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    colorB = false;
                }
                double xCenter = j + 0.5;
                double yCenter = i + 0.5;
                StdDraw.filledSquare(xCenter, yCenter, 0.5);
            }
        }


    }
}
