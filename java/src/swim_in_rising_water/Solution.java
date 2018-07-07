package swim_in_rising_water;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length, r = 0, dir[] = {-1, 0, 1, 0, -1};
        Set<Integer> seen = new HashSet<>();
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return grid[o1[0]][o1[1]] - grid[o2[0]][o2[1]];
            }
        });
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int k[] = q.poll(), row = k[0], col = k[1];
            r = Math.max(r, grid[row][col]);
            if (row == N - 1 && col == N - 1) return r;
            for (int i = 1; i < dir.length; i++) {
                int newRow = row + dir[i - 1], newCol = col + dir[i], newP = newRow * N + newCol;
                if (0 <= newRow && newRow < N && 0 <= newCol && newCol < N && !seen.contains(newP)) {
                    q.offer(new int[]{newRow, newCol});
                    seen.add(newP);
                }
            }
        }
        throw null;
    }
}
