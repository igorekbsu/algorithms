package magic_sqaures_in_grid;
public class Solution {
    public int numMagicSquaresInside(int[][] g) {
        int count = 0;
        for (int i = 0; i < g.length - 2; i++)
            for (int j = 0; j < g[0].length - 2; j++)
                if (magic(g, i, j))
                    count++;
        return count;
    }

    boolean magic(int[][] g, int r, int c) {
        int uniq[] = new int[10], rows[] = new int[3], cols[] = new int[3], d1 = 0, d2 = 0;
        for (int i = 0; i < 3; i++) {
            d1 += g[r + c][c + i];
            d2 += g[r + 2 - i][c + i];
            for (int j = 0; j < 3; j++) {
                int val = g[i + r][j + c];
                if (val < 1 || val > 9 || uniq[val] == 1)
                    return false;
                uniq[val] = 1;
                rows[i] += val;
                cols[j] += val;
            }
        }
        for (int i = 0; i < 3; i++)
            if (rows[i] != d1 || cols[i] != d1)
                return false;
        return d1 == d2;
    }
}
