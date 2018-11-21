package delete_columns_to_make_sorted;
public class Solution {
    public int minDeletionSize(String[] a) {
        int r = 0;
        for (int col = 0; col < a[0].length(); col++)
            for (int i = 1; i < a.length; i++)
                if (a[i - 1].charAt(col) > a[i].charAt(col)) {
                    r++;
                    break;
                }
        return r;
    }
}
