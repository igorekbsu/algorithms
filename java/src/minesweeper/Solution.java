package minesweeper;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().updateBoard(new char[][]{{'E', 'E'}}, new int[]{0, 0})));
    }
    public char[][] updateBoard(char[][] b, int[] click) {
        int r = click[0], c = click[1];
        if (b[r][c] == 'M')
            b[r][c] = 'X';
        else if (b[r][c] == 'E') {
            int bombs = bombs(b, r, c);
            if (bombs == 0) {
                b[r][c] = 'B';
                for (int rx = -1; rx <= 1; rx++)
                    for (int ry = -1; ry <= 1; ry++) {
                        int x = r + rx, y = c + ry;
                        if (x < 0 || x >= b.length || y < 0 || y >= b[0].length) continue;
                        updateBoard(b, new int[]{x, y});
                    }
            } else b[r][c] = Character.forDigit(bombs, 10);
        }
        return b;
    }

    int bombs(char[][] b, int row, int col) {
        int bombs = 0;
        for (int r = -1; r <= 1; r++)
            for (int c = -1; c <= 1; c++) {
                int x = row + r, y = col + c;
                if (x < 0 || x >= b.length || y < 0 || y >= b[0].length) continue;
                if (b[x][y] == 'M') bombs++;
            }
        return bombs;
    }
}
