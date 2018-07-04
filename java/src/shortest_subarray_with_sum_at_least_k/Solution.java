package shortest_subarray_with_sum_at_least_k;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167));
    }

    public int shortestSubarray(int[] a, int k) {
        int n = a.length, len = n + 1, cs[] = new int[n + 1];
        for (int i = 0; i < n; i++)
            cs[i + 1] += cs[i] + a[i];
        Deque<Integer> deck = new ArrayDeque<>(a.length);
        for (int i = 0; i <= n; i++) {
            while (deck.size() > 0 && cs[deck.getFirst()] <= cs[i] - k)
                len = Math.min(len, i - deck.pollFirst());
            deck.addLast(i);
        }
        return len <= n ? len : -1;
    }
}
