package split_array_largest_sum;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public int splitArray(int[] a, int m) {
        int max = 0;
        long sum = 0;
        for (int n : a) {
            max = Math.max(n, max);
            sum += n;
        }
        if (m == 1)
            return (int) sum;
        long lo = max, hi = sum;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (valid(mid, a, m))
                hi = mid - 1;
            else lo = mid + 1;
        }
        return (int) lo;
    }

    boolean valid(long target, int[] a, int m) {
        int count = 1;
        long total = 0;
        for (int n : a) {
            total += n;
            if (total > target) {
                total = n;
                count++;
                if (count > m)
                    return false;
            }
        }
        return true;
    }
}
