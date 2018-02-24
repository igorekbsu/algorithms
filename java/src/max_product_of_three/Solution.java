package max_product_of_three;
public class Solution {
    public static void main(String[] args) {
    }

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max3) {
                max1 = max2;
                max2 = max3;
                max3 = n;
            } else if (n > max2) {
                max1 = max2;
                max2 = n;
            } else if (n > max1)
                max1 = n;
            if (n < min2) {
                min1 = min2;
                min2 = n;
            } else if (n < min1)
                min1 = n;
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max3);
    }
}
