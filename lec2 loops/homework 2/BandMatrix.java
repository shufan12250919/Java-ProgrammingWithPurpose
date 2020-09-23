/* *****************************************************************************
 *  Name:              Shu-Fan Lin
 *  Last modified:     11, 04, 2020
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        int mid = 0;
        for (int i = 0; i < size; i++) {       // each col
            for (int j = 0; j < size; j++) {
                if (j - mid > width || mid - j > width) {   // each row
                    System.out.print("0");
                }
                else {
                    System.out.print("*");
                }
                System.out.print("  ");
            }
            mid++;
            System.out.println("");
        }
    }
}
