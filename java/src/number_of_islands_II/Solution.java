package number_of_islands_II;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numIslands2(1, 3, new int[][]{{0, 0}, {0, 2}, {0, 1}}));
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> r = new LinkedList<>();
        int roots[] = new int[m * n], dir[] = {-1, 0, 1, 0, -1}, count = 0;
        Arrays.fill(roots, -1);
        for (int[] p : positions) {
            count++;
            int root = p[0] * n + p[1];
            roots[root] = root;
            for (int i = 1; i < dir.length; i++) {
                int row = p[0] + dir[i - 1], col = p[1] + dir[i], loc = row * n + col;
                if (row >= 0 && row < m && col >= 0 && col < n && roots[loc] != -1) {
                    int nextRoot = root(roots, loc);
                    if (nextRoot != root) {
                        count--;
                        roots[root] = root = nextRoot;
                    }
                }
            }
            r.add(count);
        }
        return r;
    }

    int root(int[] roots, int id) {
        while (id != roots[id])
            id = roots[id];
        return id;
    }
}
