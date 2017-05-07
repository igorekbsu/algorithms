package permutations;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        permutations(new int[3], 1);
    }

    static void permutations(int[] a, int n) {
        if (n > a.length)
            System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++)
            if (a[i] == 0) {
                int[] b = Arrays.copyOf(a, a.length);
                b[i] = n;
                permutations(b, n + 1);
            }
    }
}