package k_th_largest_element_in_a_stream;
import java.util.PriorityQueue;

public class Solution {
    class KthLargest {
        final PriorityQueue<Integer> q;
        final int k;

        public KthLargest(int k, int[] a) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for (int n : a)
                add(n);
        }

        public int add(int n) {
            if (q.size() < k)
                q.add(n);
            else if (q.peek() < n) {
                q.poll();
                q.offer(n);
            }
            return q.peek();
        }
    }
}
