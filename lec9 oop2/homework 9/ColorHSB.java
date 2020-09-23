/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ColorHSB {
    private int hue;
    private int sat;
    private int bri;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h > 359 || h < 0) {
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        }
        if (s > 100 || s < 0) {
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        }
        if (b > 100 || b < 0) {
            throw new IllegalArgumentException("the brightness must be between 0 and 100");
        }

        hue = h;
        sat = s;
        bri = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + sat + ", " + bri + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (sat == 0 || bri == 0) {
            return true;
        }
        return false;

    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int ing = Math.abs(hue - that.hue);
        int first = Math.min((hue - that.hue) * (hue - that.hue), (360 - ing) * (360 - ing));
        int second = (sat - that.sat) * (sat - that.sat);
        int third = (bri - that.bri) * (bri - that.bri);
        return first + second + third;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        ColorHSB target = new ColorHSB(Integer.parseInt(args[0]),
                                       Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        int distance = 180 * 180 + 100 * 100 + 100 * 100;
        String close = "";
        ColorHSB found = target;
        boolean first = true;

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            if (first) {
                close = name;
                first = false;
            }
            ColorHSB current = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            if (target.distanceSquaredTo(current) < distance) {
                distance = target.distanceSquaredTo(current);
                close = name;
                found = current;
            }
        }

        StdOut.println(close + " " + found);

    }
}
