package find_k_pairs_with_smallest_sum;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<int[]> kSmallestPairs(int[] num1, int[] num2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        if (num2.length == 0) return new ArrayList<>();
        for (int i = 0; i < num1.length && i < k; i++)
            q.offer(new int[]{num1[i], num2[0], 0});
        List<int[]> r = new ArrayList<>(k);
        while (k-- > 0 && !q.isEmpty()) {
            int[] n = q.poll();
            r.add(new int[]{n[0], n[1]});
            if (n[2] == num2.length - 1) continue;
            q.offer(new int[]{n[0], num2[n[2] + 1], n[2] + 1});
        }
        return r;
    }
}
