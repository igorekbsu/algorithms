package comp;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] a, int limit) {
        Arrays.sort(a);
        int boats = 0;
        for (int hi = a.length - 1, lo = 0; hi >= lo; hi--, boats++)
            if (a[lo] + a[hi] <= limit)
                lo++;
        return boats;
    }
}
