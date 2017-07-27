package summary_ranges;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(new Solution().summaryRanges(new int[]{1}));
        System.out.println(new Solution().summaryRanges(new int[]{1, 2}));
        System.out.println(new Solution().summaryRanges(new int[]{1, 4, 9}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> r = new LinkedList<>();
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length - 1 && nums[j] == nums[j + 1] - 1)
                j++;
            r.add(i < j ? nums[i] + "->" + nums[j] : String.valueOf(nums[i]));
            i = j + 1;
        }
        return r;
    }
}
