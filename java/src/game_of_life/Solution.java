package game_of_life;
public class Solution {
    public void gameOfLife(int[][] b) {
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++) {
                int live = L(b, i - 1, j) + L(b, i - 1, j + 1) + L(b, i - 1, j - 1);
                live += L(b, i, j + 1) + L(b, i, j - 1);
                live += L(b, i + 1, j - 1) + L(b, i + 1, j) + L(b, i + 1, j + 1);
                int nextState = 0, prevState = b[i][j] & 1;
                if (prevState == 1)
                    nextState = live < 2 || live > 3 ? 0 : 1;
                else nextState = live == 3 ? 1 : 0;
                b[i][j] = (nextState << 1) + prevState;
            }
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++)
                b[i][j] = b[i][j] >> 1;
    }

    int L(int[][] b, int i, int j) {
        if (i < 0 || i == b.length || j < 0 || j == b[0].length) return 0;
        return b[i][j] & 1;
    }
}