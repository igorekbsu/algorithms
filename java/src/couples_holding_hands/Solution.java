package couples_holding_hands;
public class Solution {
    public int minSwapsCouples(int[] row) {
        int r = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i];
            if (row[i + 1] == (x ^ 1)) continue;
            r++;
            for (int j = i + 1; j < row.length; j++)
                if (row[j] == (x ^ 1)) {
                    row[j] = row[i + 1];
                    row[i + 1] = x ^ 1;
                    break;
                }
        }
        return r;
    }
}
