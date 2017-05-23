package matrix_chain;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] p = {10, 100, 5, 50};
        int[][] s = new int[p.length][p.length];
        System.out.println(minCount(p, 1, 3, s));
        printOptimal(s, 1, 3);
    }

    static void printOptimal(int[][] s, int i, int j) {
        if(i == j)
            System.out.print("A" + i);
        else {
            System.out.print("(");
            printOptimal(s, i, s[i][j]);
            printOptimal(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    static int minCount(int[] p, int k, int n, int[][] s) {
        if (k == n) return 0;
        int r = Integer.MAX_VALUE;
        for (int i = k; i < n; i++) {
            int q = minCount(p, k, i, s) + minCount(p, i + 1, n, s) + p[k - 1] * p[i] * p[n];
            if (q < r) {
                r = q;
                s[k][n] = i;
            }
        }
        return r;
    }
}
