package skyline_problem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] b = {
            {1, 2, 1},
            {1, 4, 3},
            {3, 5, 2}
        };
        List<int[]> skyline = new Solution().getSkyline(b);
        for (int[] line : skyline)
            System.out.println(Arrays.toString(line));
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>(buildings.length * 2);
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        heights.sort(new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        q.add(0);
        int prev = 0;
        List<int[]> r = new LinkedList<>();
        for (int[] h : heights) {
            if (h[1] < 0)
                q.offer(-h[1]);
            else q.remove(h[1]);
            int tallest = q.peek();
            if (tallest != prev)
                r.add(new int[]{h[0], tallest});
            prev = tallest;
        }
        return r;
    }
}
