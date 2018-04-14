package n_queens_II;
public class Solution {
    int count;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n], d1 = new boolean[2 * n], d2 = new boolean[2 * n];
        place(0, cols, d1, d2);
        return count;
    }

    void place(int row, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == cols.length) count++;
        for (int col = 0; col < cols.length; col++) {
            int id1 = row + col, id2 = cols.length + row - col;
            if (!cols[col] && !d1[id1] && !d2[id2]) {
                cols[col] = true; d1[id1] = true; d2[id2] = true;
                place(row + 1, cols, d1, d2);
                cols[col] = false; d1[id1] = false; d2[id2] = false;
            }
        }
    }
}
