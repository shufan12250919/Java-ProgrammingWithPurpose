/* *****************************************************************************
 *  Name:              Shu-fan Lin
 *  Coursera User ID:
 *  Last modified:     2020/4/3
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);
        int third = Integer.parseInt(args[2]);
        boolean ispos1 = first > 0;
        boolean ispos2 = second > 0;
        boolean ispos3 = third > 0;
        boolean ispos = ispos1 && ispos2 && ispos3;
        boolean isright1 = (third * third == first * first + second * second);
        boolean isright2 = (second * second == first * first + third * third);
        boolean isright3 = (first * first == third * third + second * second);
        boolean isright = (isright1 || isright2 || isright3) && ispos;
        System.out.println(isright);
    }
}
