package find_disappeared_numbers;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] a = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new Solution().findDisappearedNumbers(a));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int k = Math.abs(nums[i]);
            if (nums[k - 1] > 0)
                nums[k - 1] = -nums[k - 1];
        }
        List<Integer> r = new LinkedList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                r.add(i + 1);
        return r;
    }
}
