package sliding_window_max;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] a, int k) {
        if (a.length == 0) return new int[0];
        int[] r = new int[a.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>(k);
        for (int i = 0; i < a.length; i++) {
            if (!q.isEmpty() && q.peek() < i - k + 1)
                q.poll();
            while (!q.isEmpty() && a[i] >= a[q.peekLast()])
                q.pollLast();
            q.offer(i);
            if (i + 1 >= k)
                r[i - k + 1] = a[q.peek()];
        }
        return r;
    }
}
