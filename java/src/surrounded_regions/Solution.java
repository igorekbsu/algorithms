package surrounded_regions;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[][] b = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
//        char[][] b = {
//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'}
//        };
        new Solution().solve(b);
        for (char[] row : b)
            System.out.println(Arrays.toString(row));
    }

    public void solve(char[][] b) {
        if (b.length == 0 || b[0].length == 0) return;
        int n = b.length, m = b[0].length;
        for (int i = 0; i < m; i++)
            if (b[0][i] == 'O')
                visit(b, 0, i);
        for (int i = 0; i < n; i++)
            if (b[i][m - 1] == 'O')
                visit(b, i, m - 1);
        for (int i = 0; i < m; i++)
            if (b[n - 1][i] == 'O')
                visit(b, n - 1, i);
        for (int i = 0; i < n; i++)
            if (b[i][0] == 'O')
                visit(b, i, 0);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (b[i][j] == '-')
                    b[i][j] = 'O';
                else if (b[i][j] == 'O')
                    b[i][j] = 'X';
    }

    void visit(char[][] b, int i, int j) {
        if (b[i][j] == 'O') {
            b[i][j] = '-';
            if (i > 1)
                visit(b, i - 1, j);
            if (j > 1)
                visit(b, i, j - 1);
            if (i < b.length - 1)
                visit(b, i + 1, j);
            if (j < b[0].length - 1)
                visit(b, i, j + 1);
        }
    }
}
