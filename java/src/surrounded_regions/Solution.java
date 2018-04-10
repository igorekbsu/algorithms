package surrounded_regions;
public class Solution {
    public void solve(char[][] b) {
        if (b.length == 0) return;
        for (int i = 0; i < b[0].length; i++) {
            if (b[0][i] == 'O')
                dfs(b, 0, i);
            if (b[b.length - 1][i] == 'O')
                dfs(b, b.length - 1, i);
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i][0] == 'O')
                dfs(b, i, 0);
            if (b[i][b[0].length - 1] == 'O')
                dfs(b, i, b[0].length - 1);
        }
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++)
                if (b[i][j] == '-')
                    b[i][j] = 'O';
                else if (b[i][j] == 'O')
                    b[i][j] = 'X';
    }

    void dfs(char[][] b, int r, int c) {
        if (r < 0 || r >= b.length || c < 0 || c >= b[0].length || b[r][c] != 'O') return;
        b[r][c] = '-';
        dfs(b, r + 1, c);
        dfs(b, r, c + 1);
        dfs(b, r - 1, c);
        dfs(b, r, c - 1);
    }
}
