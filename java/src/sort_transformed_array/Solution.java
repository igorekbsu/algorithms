package sort_transformed_array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {-4, -2, 2, 4};
        System.out.println(Arrays.toString(new Solution().sortTransformedArray(a, 1, 3, 5)));
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] r = new int[nums.length];
        int i = a >= 0 ? nums.length - 1 : 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int vLeft = v(nums[left], a, b, c), vRight = v(nums[right], a, b, c);
            if (a >= 0) {
                if (vLeft >= vRight) {
                    r[i--] = vLeft;
                    left++;
                } else {
                    r[i--] = vRight;
                    right--;
                }
            } else {
                if (vLeft >= vRight) {
                    r[i++] = vRight;
                    right--;
                } else {
                    r[i++] = vLeft;
                    left++;
                }
            }
        }
        return r;
    }

    int v(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
