package wiggle;
public class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (i % 2 == 1) {
                if (nums[i] < nums[i - 1]) swap(nums, i, i - 1);
            } else if (nums[i] > nums[i - 1]) swap(nums, i, i - 1);
    }

    void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }
}
