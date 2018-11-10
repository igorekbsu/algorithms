package number_of_recent_calls;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    class RecentCounter {
        final Queue<Integer> q = new ArrayDeque<>(3001);

        public int ping(int t) {
            q.add(t);
            int lo = t - 3000;
            while (q.peek() < lo)
                q.poll();
            return q.size();
        }
    }
}
