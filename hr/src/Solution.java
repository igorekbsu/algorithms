import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new FileInputStream("hr/src/in"));
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            int[] a = new int[n];
            int sum = 0, max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (a[i] > 0) sum += a[i];
                if (a[i] > max) max = a[i];
            }
            if (max <= 0) {
                System.out.println(max + " " + max);
            } else {
                max = a[0];
                int contSum = a[0];
                for (int i = 1; i < n; i++) {
                    if (contSum < 0) contSum = a[i];
                    else contSum += a[i];
                    if (contSum > max)
                        max = contSum;
                }
                System.out.println(max + " " + sum);
            }
        }
    }
}
