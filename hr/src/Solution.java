import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(new FileInputStream("hr/src/in"));
        Scanner in = new Scanner(System.in);
        int[] cookies = {5, 2, 1};
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            int min = Arrays.stream(a).min().getAsInt();
            int[] mins = {min, min - 1, min - 2};
            int minCount = Integer.MAX_VALUE;
            for (int m : mins) {
                int count = 0;
                for (int i : a) {
                    int diff = i - m;
                    if (diff > 0) {
                        for (int c : cookies) {
                            count += diff / c;
                            diff = diff % c;
                        }
                    }
                }
                minCount = Math.min(count, minCount);
            }
            System.out.println(minCount);
        }
    }
}
