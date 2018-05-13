package subsets_II;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new LinkedList<>();
        subsets(0, new ArrayList<>(), nums, r);
        return r;
    }

    void subsets(int start, List<Integer> list, int[] nums, List<List<Integer>> r) {
        r.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) continue;
            list.add(nums[i]);
            subsets(i + 1, list, nums, r);
            list.remove(list.size() - 1);
        }
    }
}
