package shortest_bridge;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[][] a = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(new Solution().shortestBridge(a));
    }

    public int shortestBridge(int[][] a) {
        Set<Integer> s = new HashSet<>();
        int[] dirs = {1, 0, -1, 0, 1};
        loop:
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                if (a[i][j] == 1) {
                    dfs(a, i, j, s, dirs);
                    break loop;
                }
        int dist = 0;
        while (dist++ > -1) {
            Set<Integer> nextS = new HashSet<>();
            for (Integer n : s) {
                int i = n / a.length, j = n % a.length;
                a[i][j] = -1;
                for (int d = 1; d < dirs.length; d++) {
                    int x = i + dirs[d - 1], y = j + dirs[d];
                    if (0 <= x && x < a.length && 0 <= y && y < a.length)
                        if (a[x][y] == 1)
                            return dist;
                        else if (a[x][y] == 0)
                            nextS.add(x * a.length + y);
                }
            }
            s = nextS;
        }
        return dist;
    }

    void dfs(int[][] a, int i, int j, Set<Integer> s, int[] dirs) {
        if (i < 0 || i >= a.length || j < 0 || j >= a.length || a[i][j] <= 0) return;
        a[i][j] = -1;
        for (int d = 1; d < dirs.length; d++) {
            int x = i + dirs[d - 1], y = j + dirs[d];
            if (0 <= x && x < a.length && 0 <= y && y < a.length && a[x][y] == 0)
                s.add(x * a.length + y);
            else dfs(a, x, y, s, dirs);
        }
    }
}
