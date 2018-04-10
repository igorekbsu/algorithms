package n_queens;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] b = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(b[i], '.');
        List<List<String>> r = new LinkedList<>();
        solve(b, 0, r);
        return r;
    }

    void solve(char[][] b, int row, List<List<String>> r) {
        if (b.length == row) {
            r.add(str(b));
        } else for (int col = 0; col < b.length; col++)
            if (valid(b, row, col)) {
                b[row][col] = 'Q';
                solve(b, row + 1, r);
                b[row][col] = '.';
            }
    }

    boolean valid(char[][] b, int row, int col) {
        for (int r = 0; r < row; r++)
            if (b[r][col] == 'Q')
                return false;
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--)
            if (b[r][c] == 'Q')
                return false;
        for (int r = row - 1, c = col + 1; r >= 0 && c < b.length; r--, c++)
            if (b[r][c] == 'Q')
                return false;
        return true;
    }

    List<String> str(char[][] b) {
        List<String> r = new ArrayList<>(b.length);
        for (char[] s : b)
            r.add(new String(s));
        return r;
    }
}
