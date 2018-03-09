package find_pivot_index;
public class Solution {
    public int pivotIndex(int[] a) {
        int sum = 0, left = 0;
        for (int num : a)
            sum += num;
        for (int i = 0; i < a.length; left += a[i++])
            if (left * 2 == sum - a[i])
                return i;
        return -1;
    }
}
