package total_hamming;
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int k = 0; k < n; k++)
                bitCount += (nums[k] >> i) & 1;
            total += bitCount * (n - bitCount);
        }
        return total;
    }
}