package disappeared_numbers;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> r = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] > 0)
                nums[j] = -nums[j];
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                r.add(i + 1);
        return r;
    }
}