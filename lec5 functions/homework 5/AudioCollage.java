/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] newSound = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            newSound[i] = alpha * a[i];
        }
        return newSound;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] newSound = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            newSound[i] = a[a.length - i - 1];
        }
        return newSound;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] newSound = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            newSound[i] = a[i];
        }
        for (int j = a.length; j < (a.length + b.length); j++) {
            newSound[j] = b[j - a.length];
        }
        return newSound;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        double[] longest = a;
        double[] shortest = b;
        if (a.length < b.length) {
            longest = b;
            shortest = a;
        }
        double[] newSound = new double[longest.length];
        for (int i = 0; i < longest.length; i++) {
            if (i >= shortest.length) {
                newSound[i] = longest[i];
            }
            else {
                newSound[i] = longest[i] + shortest[i];
            }
        }
        return newSound;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] newSound = new double[(int) (a.length / alpha)];
        for (int i = 0; i < newSound.length; i++) {
            newSound[i] = a[(int) (i * alpha)];
        }
        return newSound;
    }

    // round all samples greater than +1 to +1; round all samples less than –1 to –1.
    private static double[] clamp(double[] a) {
        double[] newSound = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 1) {
                newSound[i] = 1;
            }
            else if (a[i] < -1) {
                newSound[i] = -1;
            }
            else {
                newSound[i] = a[i];
            }
        }
        return newSound;

    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] first = StdAudio.read("beatbox.wav");
        double[] second = StdAudio.read("harp.wav");
        double[] third = StdAudio.read("piano.wav");
        double[] forth = StdAudio.read("singer.wav");
        double[] fifth = StdAudio.read("cow.wav");

        double[] firstP = reverse(fifth);
        double[] secondP = mix(first, second);
        double[] secondPP = changeSpeed(first, 0.75);
        double[] thirdP = mix(secondPP, third);
        double[] forthP = merge(secondP, thirdP);
        forthP = merge(forthP, forth);
        double[] fifthP = amplify(forthP, 1.25);
        double[] finalS = merge(fifthP, firstP);
        finalS = clamp(finalS);
        StdAudio.play(finalS);


    }
}
