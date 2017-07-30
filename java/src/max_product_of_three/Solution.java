package max_product_of_three;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumProduct(new int[]{1, 2, 3}));
    }

    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3)
                max3 = n;
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2)
                min2 = n;
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
