package find_min_in_rotated_array;
public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] > nums[hi])
                lo = mid;
            else
                hi = mid;
        }
        return nums[lo];
    }
}
