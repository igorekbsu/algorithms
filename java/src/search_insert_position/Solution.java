package search_insert_position;
public class Solution {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) hi = mid;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}
