package skyline;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        //int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] buildings = {{1, 2, 1}, {1, 2, 2}};
        List<int[]> skyline = new Solution().getSkyline(buildings);
        for (int[] ints : skyline) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new LinkedList<>(), height = new LinkedList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        height.sort((o1, o2) -> {
            int r = o1[0] - o2[0];
            if (r == 0) r = o1[1] - o2[1];
            return r;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pq.add(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0)
                pq.add(-h[1]);
            else
                pq.remove(h[1]);
            Integer current = pq.peek();
            if (current != prev) {
                result.add(new int[]{h[0], current});
                prev = current;
            }
        }
        return result;
    }
}
