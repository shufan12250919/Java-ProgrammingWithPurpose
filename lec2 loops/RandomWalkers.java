/* *****************************************************************************
 *  Name:              Shu-Fan Lin
 *  Last modified:     11, 04, 2020
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int distance = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        int steps = 0;
        double avgsteps = 0.0;
        for (int i = 0; i < trails; i++) {
            int xPos = 0;
            int yPos = 0; // start at (0, 0)
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
            }
        }
        avgsteps = 1.0 * steps / trails;
        System.out.println("average number of steps = " + avgsteps);

    }
}
