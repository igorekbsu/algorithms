package com;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().consecutiveNumbersSum(43156417));
        System.out.println(new Solution().consecutiveNumbersSum(9));
    }

    public int consecutiveNumbersSum(int N) {
        int count = 0;
        Set<Float> used = new HashSet<>();
        for (int x = 1; (x * (x + 1)) < 2.0 * N; x++) {
            float r = (float) (2.0 * N - x * (x + 1)) / (2 * (x + 1));
            if (r < Integer.MAX_VALUE && r - (int) r == 0)
                count++;
        }
        return count + 1;
    }
}
