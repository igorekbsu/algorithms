package k_largest;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {
        if (start > end) return -1;
        int pivot = nums[end], left = start;
        for (int i = start; i < end; i++)
            if (nums[i] <= pivot)
                swap(nums, left++, i);
        swap(nums, left, end);
        if (left == k) return nums[left];
        else if (left < k)
            return findKthLargest(nums, left + 1, end, k);
        else
            return findKthLargest(nums, start, left - 1, k);
    }

    void swap(int[] a, int i, int j) {
        if (i != j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}