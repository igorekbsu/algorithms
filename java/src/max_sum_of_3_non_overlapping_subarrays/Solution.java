package max_sum_of_3_non_overlapping_subarrays;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));
    }

    public int[] maxSumOfThreeSubarrays(int[] a, int k) {
        int n = a.length, cs[] = new int[n + 1], rPos[] = new int[n], lPos[] = new int[n];
        for (int i = 0; i < n; i++)
            cs[i + 1] = cs[i] + a[i];
        for (int i = k, max = cs[k]; i < n; i++)
            if (cs[i + 1] - cs[i + 1 - k] > max) {
                max = cs[i + 1] - cs[i + 1 - k];
                lPos[i] = i + 1 - k;
            } else lPos[i] = lPos[i - 1];
        rPos[n - k] = n - k;
        for (int i = n - k - 1, max = cs[n] - cs[n - k]; i >= 0; i--)
            if (cs[i + k] - cs[i] >= max) {
                max = cs[i + k] - cs[i];
                rPos[i] = i;
            } else rPos[i] = rPos[i + 1];
        int r[] = new int[3], maxSum = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int L = lPos[i - 1], R = rPos[i + k];
            int sum = cs[i + k] - cs[i] + cs[L + k] - cs[L] + cs[R + k] - cs[R];
            if (sum > maxSum) {
                maxSum = sum;
                r[0] = L; r[1] = i; r[2] = R;
            }
        }
        return r;
    }
}
