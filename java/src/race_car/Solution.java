package race_car;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(-12%10);
    }

    public int racecar(int target) {
        int K = 33 - Integer.numberOfLeadingZeros(target - 1), limit = 1 << K;
        int[] dp = new int[2 * limit + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[target] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override public int compare(Node o1, Node o2) {
                return o1.steps - o2.steps;
            }
        });
        pq.offer(new Node(0, target));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int steps = node.steps, target1 = node.target;
            if (dp[target1 % dp.length] > steps) continue;
            for (int k = 0; k <= K; ++k) {
                int walk = (1 << k) - 1;
                int target2 = walk - target1;
                int steps2 = steps + k + (target2 != 0 ? 1 : 0);
                if (Math.abs(target2) <= limit && steps2 < dp[target2 % dp.length]) {
                    pq.offer(new Node(steps2, target2));
                    dp[Math.floorMod(target2, dp.length)] = steps2;
                }
            }
        }

        return dp[0];
    }

    class Node {
        int steps, target;

        Node(int s, int t) {
            steps = s;
            target = t;
        }
    }

}
