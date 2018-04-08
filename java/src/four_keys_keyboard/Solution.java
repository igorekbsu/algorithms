package four_keys_keyboard;
public class Solution {
    int[] cache = new int[51];

    public int maxA(int N) {
        if (cache[N] > 0)
            return cache[N];
        int max = N;
        for (int i = 1; i <= N - 3; i++)
            max = Math.max(max, maxA(i) * (N - i - 1));
        cache[N] = max;
        return max;
    }
}
