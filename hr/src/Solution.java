import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++)
            System.out.println(isPrime(in.nextInt()) ? "Prime" : "Not prime");
    }

    static boolean isPrime(int n) {
        if (n == 1) return false;
        double sqrt = Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++)
            if (n % i == 0) return false;
        return true;
    }
}
