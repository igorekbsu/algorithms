package com;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (m.containsKey(diff))
                return new int[]{m.get(diff), i};
            m.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}
