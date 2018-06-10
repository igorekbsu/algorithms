package count_of_range_sum;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864));
    }

    public int countRangeSum(int[] a, int lower, int upper) {
        long[] cs = new long[a.length + 1];
        for (int i = 0; i < a.length; i++)
            cs[i + 1] = cs[i] + a[i];
        int count = 0;
        for (int i = 0; i <= a.length; i++)
            for (int j = 0; j < i; j++)
                if (cs[i] - cs[j] >= lower && cs[i] - cs[j] <= upper)
                    count++;
        return count;
    }
}
