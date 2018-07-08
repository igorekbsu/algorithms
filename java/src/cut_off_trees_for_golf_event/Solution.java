package cut_off_trees_for_golf_event;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> forest = Arrays.asList(
            Arrays.asList(3, 1),
            Arrays.asList(0, 1),
            Arrays.asList(2, 1)
        );
        System.out.println(new Solution().cutOffTree(forest));
    }

    public int cutOffTree(List<List<Integer>> f) {
        if (f.size() == 0) return 0;
        int sum = 0, prevRow = 0, prevCol = 0, m = f.size(), n = f.get(0).size(), d[] = {-1, 0, 1, 0, -1};
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (f.get(i).get(j) > 1)
                    pq.offer(new int[]{i, j, f.get(i).get(j)});
        while (!pq.isEmpty()) {
            int e[] = pq.poll(), row = e[0], col = e[1];
            int minSteps = bfs(prevRow, prevCol, row, col, f, d, m, n);
            if (minSteps == -1)
                return -1;
            sum += minSteps;
            prevRow = row;
            prevCol = col;
        }
        return sum;
    }

    int bfs(int prevRow, int prevCol, int nextRow, int nextCol, List<List<Integer>> f, int[] d, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        q.offer(new int[]{prevRow, prevCol});
        seen[prevRow][prevCol] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                int[] p = q.poll();
                if (p[0] == nextRow && p[1] == nextCol)
                    return steps;
                for (int k = 1; k < d.length; k++) {
                    int nr = p[0] + d[k - 1], nc = p[1] + d[k];
                    if (0 <= nr && nr < m && 0 <= nc && nc < n && f.get(nr).get(nc) != 0 && !seen[nr][nc]) {
                        q.offer(new int[]{nr, nc});
                        seen[nr][nc] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
