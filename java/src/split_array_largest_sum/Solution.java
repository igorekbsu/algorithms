package split_array_largest_sum;
public class Solution {
    public int pathSum(int[] a) {
        int[][] sum = new int[5][9];
        boolean[][] notLeaf = new boolean[5][9];
        for (int i : a) {
            int d = i / 100, p = i % 100 / 10, val = i % 10;
            sum[d][p] = val + sum[d - 1][(p + 1) / 2];
            notLeaf[d - 1][(p + 1) / 2] = true;
        }
        int r = 0;
        for (int i = 1; i < 5; i++)
            for (int j = 1; j < 9; j++)
                if (!notLeaf[i][j])
                    r += sum[i][j];
        return r;
    }
}
