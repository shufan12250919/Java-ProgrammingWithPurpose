/* *****************************************************************************
 *  Name:              Shu-Fan Lin
 *  Coursera User ID:
 *  Last modified:     2020/4/13
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {
        int xMax = StdIn.readInt();
        int yMax = StdIn.readInt();
        StdDraw.setCanvasSize(xMax, yMax);
        StdDraw.setXscale(0.0, xMax);
        StdDraw.setYscale(0.0, yMax);
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int numbers = StdIn.readInt();
            double[] xPos = new double[numbers];
            double[] yPos = new double[numbers];
            for (int i = 0; i < numbers; i++) {
                xPos[i] = StdIn.readDouble(); // read for x position
                yPos[i] = StdIn.readDouble(); // read for y position
            }
            StdDraw.polygon(xPos, yPos);
        }

    }
}
