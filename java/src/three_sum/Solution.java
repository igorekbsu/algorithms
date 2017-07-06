package three_sum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int lo = i + 1, hi = nums.length - 1;
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == -nums[i]) {
                        r.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] > -nums[i])
                        hi--;
                    else lo++;
                }
            }
        }
        return r;
    }

    public int threeSumSmaller(int[] nums, int target) {
        int n = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    n += right - left;
                    left++;
                } else right--;
            }
        }
        return n;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < target)
                    left++;
                else if (sum > target)
                    right--;
                else
                    return target;
                if (Math.abs(target - sum) < Math.abs(closest - target))
                    closest = sum;
            }
        }
        return closest;
    }
}