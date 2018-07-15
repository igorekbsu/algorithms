package shortest_distance_from_all_buildings;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
//        input[][] grid = {
//                {1, 0},
//                {0, 0}
//        };
        System.out.println(new Solution().shortestDistance(grid));
    }

    public int shortestDistance(int[][] grid) {
        int N = 0, toVisit = 0, n = grid.length, m = grid[0].length;
        int[][] total = new int[n][m], reach = new int[n][m];
        int[] delta = {0, 1, 0, -1, 0};
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1) {
                    N++;
                    int distance = 1;
                    Queue<int[]> q = new LinkedList<>();
                    grid[i][j] = toVisit - 1;
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int size = q.size();
                        for (int k = 0; k < size; k++) {
                            int[] ij = q.poll();
                            for (int d = 0; d < 4; d++) {
                                int a = ij[0] + delta[d], b = ij[1] + delta[d + 1];
                                if (a >= 0 && a < n && b >= 0 && b < m && grid[a][b] == toVisit) {
                                    grid[a][b]--;
                                    total[a][b] += distance;
                                    reach[a][b]++;
                                    q.add(new int[]{a, b});
                                }
                            }
                        }
                        distance++;
                    }
                    grid[i][j] = 1;
                    toVisit--;
                }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] < 0 && reach[i][j] == N && min > total[i][j])
                    min = total[i][j];
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
