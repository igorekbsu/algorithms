package burst_balloons;
public class Solution {
    public int maxCoins(int[] nums) {
        int a[] = new int[nums.length + 2], n = 1, cache[][] = new int[nums.length + 2][nums.length + 2];
        for (int num : nums)
            a[n++] = num;
        a[0] = a[n] = 1;
        return burst(a, 0, n, cache);
    }

    int burst(int[] a, int left, int right, int[][] cache) {
        if (left + 1 == right) return 0;
        if (cache[left][right] > 0) return cache[left][right];
        int r = 0;
        for (int i = left + 1; i < right; i++)
            r = Math.max(r, a[left] * a[i] * a[right] + burst(a, left, i, cache) + burst(a, i, right, cache));
        cache[left][right] = r;
        return r;
    }
}