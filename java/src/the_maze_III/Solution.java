package the_maze_III;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] maze = {
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {0, 1, 0, 0, 0}
        };
        System.out.println(new Solution().findShortestWay(maze, new int[]{4, 3}, new int[]{0, 1}));
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length, m = maze[0].length, dp[][] = new int[n][m], dir[] = {-1, 0, 1, 0, -1};
        String[][] paths = new String[n][m];
        char[] ways = {'u', 'r', 'd', 'l'};
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            Arrays.fill(paths[i], "");
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(ball);
        dp[ball[0]][ball[1]] = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 1; i < dir.length; i++) {
                int x = p[0], y = p[1], distance = dp[x][y];
                String path = paths[x][y];
                boolean done = false;
                while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] != 1 && !done) {
                    if (x == hole[0] && y == hole[1])
                        done = true;
                    x += dir[i - 1];
                    y += dir[i];
                    distance++;
                }
                x -= dir[i - 1];
                y -= dir[i];
                distance--;
                path = path + ways[i - 1];
                if (distance < dp[x][y] || (distance == dp[x][y] && path.compareTo(paths[x][y]) < 0)) {
                    dp[x][y] = distance;
                    paths[x][y] = path;
                    if (!done)
                        q.offer(new int[]{x, y});
                }
            }
        }
        String path = paths[hole[0]][hole[1]];
        return path.isEmpty() ? "impossible" : path;
    }
}

