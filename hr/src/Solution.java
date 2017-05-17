import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("hr/src/in"));
        int n = in.nextInt(), s = in.nextInt(), t = in.nextInt();
        int[] r = new int[n];
        r[0] = in.nextInt();
        int g = in.nextInt(), seed = in.nextInt(), p = in.nextInt();
        if (s == t) System.out.println(0);
        else {
            for (int i = 1; i < n; i++)
                r[i] = (r[i - 1] * g + seed) % p;
            int seconds = seconds(s, t, r, n);
            System.out.println(seconds);
        }

    }

    static int seconds(int s, int t, int[] r, int n) {
        if (s == t) return 0;
        if (r[s] == 0) return -1;
        int min = 1;
        for (int i = 1; i <= r[s]; i++) {
            int s1 = (s + i) % n;
            int c1 = 1 + seconds(s1, t, r, n);
            int s2 = (s - i);
            if (s2 < 0) s2 += n;
            int c2 = 1 + seconds(s2, t, r, n);
            int cmin = Math.min(c1, c2);
            min = Math.min(cmin, min);
        }
        return 1 + min;
    }
}