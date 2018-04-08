package skyline_problem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> r = new LinkedList<>(), heights = new ArrayList<>(buildings.length * 2);
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        heights.sort(Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(0);
        int prev = 0;
        for (int[] h : heights) {
            if (h[1] < 0)
                pq.add(-h[1]);
            else pq.remove(h[1]);
            int tallest = pq.peek();
            if (tallest != prev)
                r.add(new int[]{h[0], tallest});
            prev = tallest;
        }
        return r;
    }
}
