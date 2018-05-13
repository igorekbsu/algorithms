package coin_path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().cheapestJump(new int[]{0, 0, 0, 0, 0, 0}, 3));
    }

    public List<Integer> cheapestJump(int[] A, int B) {
        int[] next = new int[A.length], dp = new int[A.length];
        Arrays.fill(next, -1);
        for (int i = A.length - 2; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + B && j < A.length; j++) {
                if (A[j] >= 0) {
                    int cost = A[i] + dp[j];
                    if (cost < minCost) {
                        minCost = cost;
                        next[i] = j;
                    }
                }
            }
            dp[i] = minCost;
        }
        List<Integer> r = new LinkedList<>();
        int i;
        for (i = 0; i < A.length && next[i] > 0; i = next[i])
            r.add(i + 1);
        if (i == A.length - 1 && A[i] >= 0)
            r.add(A.length);
        else return new ArrayList<>(0);
        return r;
    }
}
