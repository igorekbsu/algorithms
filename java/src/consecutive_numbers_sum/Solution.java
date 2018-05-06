package consecutive_numbers_sum;
public class Solution {
    public int consecutiveNumbersSum(int N) {
        int r = 1;
        for (int i = 2; (1 + i) * i * 0.5 <= N; i++)
            if ((N - (1 + i) * i * 0.5) % i == 0) r++;
        return r;
    }
}
