package arithmetic_slices;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1, 2, 4, 6, 8, 11, 14, 0, 4, 8}));
    }

    public int numberOfArithmeticSlices(int[] a) {
        int count = 0, start = 0;
        for (int i = 2; i <= a.length; i++)
            if (i == a.length || a[i] - a[i - 1] != a[i - 1] - a[i - 2]) {
                int n = i - start;
                count += (n - 2) * (n - 1) * 0.5;
                start = i - 1;
            }
        return count;
    }
}
