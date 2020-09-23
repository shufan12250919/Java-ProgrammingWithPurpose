/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int max = 0;
        int current = 1;
        boolean cont = false;
        for (int i = 0; i < dna.length() - 2; i++) {
            if (dna.substring(i, i + 3).equals("CAG")) {
                if (!cont) {
                    current = 1;
                    cont = true;
                }
                else {
                    current++;
                }
                if (current > max) {
                    max++;
                }
                i = i + 2;
            }
            else {
                cont = false;
            }
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String newOne = s.replace("\t", "");
        String newTwo = newOne.replace("\n", "");
        String newThree = newTwo.replace(" ", "");
        return newThree;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 181) return "not human";
        else if (maxRepeats >= 40) return "Huntington’s";
        else if (maxRepeats >= 36) return "high risk";
        else if (maxRepeats >= 10) return "normal";
        else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);
        String contents = in.readAll();
        String content = removeWhitespace(contents);
        // StdOut.println(removeWhitespace(content));
        int max = maxRepeats(content);
        StdOut.println("max repeats = " + max);
        StdOut.println(diagnose(max));

    }
}
