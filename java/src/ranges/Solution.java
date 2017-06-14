package ranges;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missing = new ArrayList<>();
        long lastOut = lower;
        for (int n : nums) {
            addMissing(lastOut, n - 1L, missing);
            lastOut = n + 1;
        }
        addMissing(lastOut, upper, missing);
        return missing;
    }

    void addMissing(long lastOut, long nextOut, List<String> ranges) {
        if (lastOut == nextOut) {
            ranges.add(Long.toString(lastOut));
        } else if (lastOut < nextOut)
            ranges.add(lastOut + "->" + nextOut);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) return ranges;
        int s = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (nums[i - 1] + 1 != nums[i]) {
                ranges.add(range(s, nums[i - 1]));
                s = nums[i];
            }
        ranges.add(range(s, nums[nums.length - 1]));
        return ranges;
    }

    String range(int s, int e) {
        return s == e ? Integer.toString(s) : s + "->" + e;
    }
}