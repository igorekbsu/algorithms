package k_smallest_in_sorted_matrix;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] m = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        System.out.println(new Solution().kthSmallest(m, 8));
    }

    public int kthSmallest(int[][] m, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < m[0].length; i++)
            pq.offer(new int[]{0, i, m[0][i]});
        for (; k > 1; k--) {
            int[] t = pq.poll();
            if (t[0] == m.length - 1) continue;
            pq.offer(new int[]{t[0] + 1, t[1], m[t[0] + 1][t[1]]});
        }
        return pq.poll()[2];
    }
}
