/* *****************************************************************************
 *  Name:              Shu-Fan Lin
 *  Last modified:     11, 04, 2020
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int distance = Integer.parseInt(args[0]);
        int steps = 0;
        int xPos = 0;
        int yPos = 0; // start at (0, 0)
        System.out.println("(" + xPos + ", " + yPos + ")");
        while (Math.abs(xPos) + Math.abs(yPos) != distance) {
            int forword = (int) (Math.random() * 4);
            if (forword == 0) {
                xPos++;
            }
            else if (forword == 1) {
                xPos--;
            }
            else if (forword == 2) {
                yPos++;
            }
            else if (forword == 3) {
                yPos--;
            }
            steps++;
            System.out.println("(" + xPos + ", " + yPos + ")");
        }
        System.out.println("steps = " + steps);

    }
}
