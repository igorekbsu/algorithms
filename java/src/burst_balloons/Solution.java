package burst_balloons;
public class Solution {
    public static void main(String[] args) {
        int[] a = {3, 1, 5, 8};
        System.out.println(new Solution().maxCoins(a));
    }

    public int maxCoins(int[] nums) {
        int[] a = new int[nums.length + 2];
        int n = 1;
        for (int num : nums)
            if (num != 0)
                a[n++] = num;
        a[0] = a[n] = 1;
        int[][] cache = new int[n + 1][n + 1];
        return maxCoins(a, 0, n, cache);
    }

    int maxCoins(int[] a, int left, int right, int[][] cache) {
        if (left + 1 == right) return 0;
        if (cache[left][right] > 0)
            return cache[left][right];
        int max = 0;
        for (int i = left + 1; i < right; i++)
            max = Math.max(max, a[i] * a[left] * a[right] + maxCoins(a, left, i, cache) + maxCoins(a, i, right, cache));
        cache[left][right] = max;
        return max;
    }
}
