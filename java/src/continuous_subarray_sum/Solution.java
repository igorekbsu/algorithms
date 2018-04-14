package continuous_subarray_sum;
public class Solution {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(new Solution().checkSubarraySum(a, 5));
    }

    public boolean checkSubarraySum(int[] a, int k) {
        k = Math.abs(k);
        for (int i = 1; i < a.length; i++)
            a[i] += a[i - 1];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == k || (k > 0 && a[i] % k == 0)) return true;
            for (int j = 0; j <= i - 2; j++)
                if (a[i] == k || (k > 0 && (a[i] - a[j]) % k == 0))
                    return true;
        }
        return false;
    }
}
