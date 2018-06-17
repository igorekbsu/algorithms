package max_avr_subarray_II;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    public double findMaxAverage(int[] a, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++)
            sum += a[i];
        double max = sum / k;
        for (; k < a.length; k++) {
            double cs = sum, localMax = cs;
            for (int j = k; j < a.length; j++) {
                cs += a[j] - a[j - k];
                localMax = Math.max(localMax, cs);
            }
            sum += a[k];
            max = Math.max(max, localMax / k);
        }
        return max;
    }
}
