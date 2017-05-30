import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt(), k = in.nextInt();
            if ((k | (k - 1)) <= n)
                System.out.println(k - 1);
            else System.out.println(k - 2);
        }
    }
}
