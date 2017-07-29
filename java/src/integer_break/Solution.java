package integer_break;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(5));
    }

    public int integerBreak(int n) {
        if (n == 1 || n == 2) return 1;
        if (n == 3) return 2;
        int[] cache = new int[n + 1];
        return integerBreak(n, cache);
    }

    int integerBreak(int n, int[] cache) {
        if (cache[n] > 0)
            return cache[n];
        int max = n;
        for (int i = 1; i <= n / 2; i++)
            max = Math.max(max, i * integerBreak(n - i, cache));
        cache[n] = max;
        return max;
    }
}
