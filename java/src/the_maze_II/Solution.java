package the_maze_II;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] maze = {{0, 0}, {0, 0}};
        System.out.println(new Solution().shortestDistance(maze, new int[]{0, 0}, new int[]{1, 1}));
    }

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length, len[][] = new int[m][n], dir[] = {-1, 0, 1, 0, -1};
        for (int i = 0; i < m; i++)
            Arrays.fill(len[i], Integer.MAX_VALUE);
        len[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int j = 1; j < dir.length; j++) {
                int x = curr[0] + dir[j - 1], y = curr[1] + dir[j], count = 0;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[j - 1];
                    y += dir[j];
                    count++;
                }
                x -= dir[j - 1];
                y -= dir[j];
                int d = len[curr[0]][curr[1]];
                if (x == dest[0] && y == dest[1])
                    len[x][y] = Math.min(len[x][y], d + count);
                else if (d + count < len[x][y]) {
                    len[x][y] = d + count;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return len[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : len[dest[0]][dest[1]];
    }
}
