import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = {3, 5, 2, 1, 6, 4};
        new Solution().wiggleSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++)
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1])
                    swap(nums, i, i + 1);
            } else {
                if (nums[i] < nums[i + 1])
                    swap(nums, i, i + 1);
            }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
