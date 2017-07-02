import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> r = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] < 0) r.add(j + 1);
            else nums[j] = -nums[j];
        }
        return r;
    }
}