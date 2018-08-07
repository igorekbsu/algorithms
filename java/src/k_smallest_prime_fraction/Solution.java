package k_smallest_prime_fraction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
    }
    public int[] kthSmallestPrimeFraction(int[] a, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                int n1 = a[o1[0]], d1 = a[o1[1]];
                int n2 = a[o2[0]], d2 = a[o2[1]];
                return n1 * d2 - n2 * d1;
            }
        });
        for (int i = 0; i < a.length - 1; i++)
            q.offer(new int[]{i, a.length - 1});
        while (--k > 0) {
            int[] e = q.poll();
            if (e[0] + 1 < e[1])
                q.offer(new int[]{e[0], e[1] - 1});
        }
        return new int[]{a[q.peek()[0]], a[q.peek()[1]]};
    }
}
