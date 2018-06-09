package wiggle_subsequence;
public class Solution {
    public int wiggleMaxLength(int[] a) {
        if(a.length == 0)return 0;
        int up = 1, down = 1;
        for (int i = 1; i < a.length; i++)
            if (a[i - 1] < a[i])
                up = down + 1;
            else if (a[i - 1] > a[i])
                down = up + 1;
        return Math.max(up, down);
    }
}
