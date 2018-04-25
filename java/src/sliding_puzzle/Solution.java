package sliding_puzzle;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[][] b = {{4, 1, 2}, {5, 0, 3}};
        System.out.println(new Solution().slidingPuzzle(b));
    }

    public int slidingPuzzle(int[][] b) {
        String win = "123450", curr = str(b);
        if (win.equals(curr)) return 0;
        int d = 1, dirs[] = {-1, 0, 1, 0, -1};
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.add(curr);
        seen.add(curr);
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                curr = q.poll();
                int[][] board = board(curr);
                List<String> next = move(board, dirs);
                for (String s : next)
                    if (s.equals(win)) return d;
                    else if (seen.add(s))
                        q.add(s);
            }
            d++;
        }
        return -1;
    }

    List<String> move(int[][] board, int[] dirs) {
        List<String> moves = new LinkedList<>();
        int row = 0, col = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == 0) {
                    row = i; col = j; break;
                }
        for (int i = 1; i < dirs.length; i++) {
            int r = row + dirs[i], c = col + dirs[i - 1];
            if (r < 0 || r > 1 || c < 0 || c > 2) continue;
            swap(board, row, col, r, c);
            moves.add(str(board));
            swap(board, row, col, r, c);
        }
        return moves;
    }

    void swap(int[][] b, int r1, int c1, int r2, int c2) {
        int t = b[r1][c1];
        b[r1][c1] = b[r2][c2];
        b[r2][c2] = t;
    }

    String str(int[][] b) {
        StringBuilder r = new StringBuilder(6);
        for (int[] row : b)
            for (int n : row)
                r.append(n);
        return r.toString();
    }

    int[][] board(String s) {
        int[][] r = new int[2][3];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                r[i][j] = s.charAt(3 * i + j) - '0';
        return r;
    }
}
