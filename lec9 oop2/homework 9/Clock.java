/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Clock {
    private int hour;
    private int min;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h > 23 || h < 0) {
            throw new IllegalArgumentException("the hours must be between 0 and 23");
        }
        if (m > 59 || m < 0) {
            throw new IllegalArgumentException("the minutes must be between 0 and 59");
        }
        hour = h;
        min = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5) {
            throw new IllegalArgumentException("the format is wrong");
        }
        int first = Integer.parseInt(s.substring(0, 2));
        int second = Integer.parseInt(s.substring(3, 5));
        if (first > 23 || second > 59) {
            throw new IllegalArgumentException("the format is wrong");
        }
        if (!s.substring(2, 3).equals(":")) {
            throw new IllegalArgumentException("the format is wrong");
        }
        hour = first;
        min = second;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        if (hour < 10 && min < 10) {
            return "0" + hour + ":0" + min;
        }
        if (hour < 10) {
            return "0" + hour + ":" + min;
        }
        if (min < 10) {
            return hour + ":0" + min;
        }
        return hour + ":" + min;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hour > that.hour) {
            return false;
        }
        if (hour < that.hour) {
            return true;
        }
        if (min >= that.min) {
            return false;
        }
        return true;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (min == 59) {
            min = 0;
            if (hour == 23) {
                hour = 0;
            }
            else {
                hour++;
            }
        }
        else {
            min++;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("the delta must be bigger then 0");
        }
        if (delta < 60) {
            for (int i = 0; i < delta; i++) {
                this.tic();
            }
        }
        else {
            int addH = delta / 60;
            int addM = delta % 60;
            if (hour + addH < 24) {
                hour += addH;
            }
            else {
                hour = (hour + addH) % 24;
            }
            for (int i = 0; i < addM; i++) {
                this.tic();
            }
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock first = new Clock(23, 59);
        System.out.println(first);
        Clock second = new Clock("12:59");
        System.out.println(second);
        Clock third = new Clock(2, 10);
        System.out.println(third);
        System.out.println(first.isEarlierThan(second));
        System.out.println(second.isEarlierThan(first));
        first.tic();
        System.out.println(first);
        second.tic();
        System.out.println(second);
        first.toc(1800);
        System.out.println(first);
    }
}
