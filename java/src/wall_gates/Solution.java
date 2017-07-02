package wall_gates;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] g = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };
        new Solution().wallsAndGates(g);
        print(g);
    }

    static void print(int[][] a) {
        for (int[] row : a) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0)
                    visit(rooms, i, j, 0);
    }

    void visit(int[][] a, int i, int j, int d) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] < d) return;
        a[i][j] = d;
        visit(a, i + 1, j, d + 1);
        visit(a, i, j - 1, d + 1);
        visit(a, i, j + 1, d + 1);
        visit(a, i - 1, j, d + 1);
    }
}