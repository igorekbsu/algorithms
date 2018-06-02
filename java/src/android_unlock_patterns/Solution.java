package android_unlock_patterns;
public class Solution {
    public int numberOfPatterns(int m, int n) {
        int r = 0;
        for (int len = m; len <= n; len++)
            r += calcPatterns(-1, len, new boolean[9]);
        return r;
    }

    int calcPatterns(int prev, int len, boolean[] used) {
        if (len == 0) return 1;
        int r = 0;
        for (int i = 0; i < 9; i++)
            if (!used[i] && valid(i, prev, used)) {
                used[i] = true;
                r += calcPatterns(i, len - 1, used);
                used[i] = false;
            }
        return r;
    }

    boolean valid(int curr, int prev, boolean[] used) {
        if (prev == -1) return true;
        // knight moves or adjacent cells (in a row or in a column)
        if ((curr + prev) % 2 == 1) return true;
        // indexes are at both end of the diagonals for example 0,0, and 8,8
        int mid = (curr + prev) / 2;
        if (mid == 4) return used[mid];
        // adjacent cells on diagonal  - not same row and column
        if ((curr % 3 != prev % 3) && (curr / 3 != prev / 3))
            return true;
        // all other cells which are not adjacent
        return used[mid];
    }

}
