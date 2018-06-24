package min_cost_to_hire_k_workers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] q = {10, 20, 5};
        int[] w = {70, 50, 30};
        System.out.println(new Solution().mincostToHireWorkers(q, w, 2));
    }

    public double mincostToHireWorkers(int[] q, int[] w, int k) {
        Worker[] workers = new Worker[q.length];
        for (int i = 0; i < q.length; i++)
            workers[i] = new Worker(w[i], q[i]);
        Arrays.sort(workers, new Comparator<Worker>() {
            @Override public int compare(Worker o1, Worker o2) {
                return Double.compare(o1.wq, o2.wq);
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        double qSum = 0, r = Double.MAX_VALUE;
        for (Worker worker : workers) {
            qSum += worker.q;
            pq.add(-worker.q);
            if (pq.size() > k)
                qSum += pq.poll();
            if (pq.size() == k)
                r = Math.min(r, qSum * worker.wq);
        }
        return r;
    }

    class Worker {
        final int q;
        final double wq;

        Worker(int w, int q) {
            this.q = q;
            wq = 1.0 * w / q;
        }

        @Override public String toString() {
            return q + "," + wq;
        }
    }
}
