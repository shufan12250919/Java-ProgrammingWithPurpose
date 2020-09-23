/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        int[] count = new int[n + 2];
        int large = 0;
        for (int i = 0; i < trails; i++) {
            boolean[] birthdays = new boolean[n];
            int person = 1;
            int day = (int) (Math.random() * n); // the first person
            birthdays[day] = true;
            while (true) {
                person++; // next person enter the room
                day = (int) (Math.random() * n);  // define new birthday
                if (birthdays[day]) {   // if birthday encounter the same, then break
                    break;
                }
                birthdays[day] = true;
            }
            count[person]++;
            if (person > large) {   // large is use for output
                large = person;
            }
        }
        int sumCount = 0;   // check for i or fewer close expirement
        for (int i = 0; i < large; i++) {
            sumCount += count[i + 1];
            double percent = 1.0 * sumCount / trails;
            System.out.println((i + 1) + "\t" + count[i + 1] + "\t" + percent);
            if (percent >= 0.5) {
                break;
            }
        }

    }
}
