package game_of_life;
public class Solution1 {
    public void gameOfLife(int[][] b) {
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++) {
                int count = C(b, i - 1, j - 1) + C(b, i - 1, j) + C(b, i, j - 1);
                count += C(b, i + 1, j) + C(b, i, j + 1) + C(b, i + 1, j + 1);
                count += C(b, i - 1, j + 1) + C(b, i + 1, j - 1);
                if (b[i][j] == 0 && count == 3)
                    b[i][j] = 2;
                else if (b[i][j] == 1 && (count == 2 || count == 3))
                    b[i][j] |= 2;
            }
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++)
                b[i][j] = b[i][j] >> 1;
    }

    int C(int[][] b, int i, int j) {
        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length)
            return 0;
        return b[i][j] & 1;
    }
}
