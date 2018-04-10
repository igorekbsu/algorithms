package the_maze;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean hasPath(int[][] maze, int[] s, int[] d) {
        if (s[0] == d[0] && s[1] == d[1]) return true;
        int[] dir = {-1, 0, 1, 0, -1};
        maze[s[0]][s[1]] = -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 1; i < dir.length; i++) {
                int rowIncrement = dir[i - 1], colIncrement = dir[i], prevR = curr[0], prevC = curr[1];
                while (true) {
                    int r = prevR + rowIncrement, c = prevC + colIncrement;
                    if (r < 0 || r >= maze.length || c < 0 || c >= maze[0].length || maze[r][c] == 1) {
                        if (prevR == d[0] && prevC == d[1]) return true;
                        if (maze[prevR][prevC] != -1) {
                            maze[prevR][prevC] = -1;
                            q.add(new int[]{prevR, prevC});
                        }
                        break;
                    }
                    prevC = c;
                    prevR = r;
                }
            }
        }
        return false;
    }
}
