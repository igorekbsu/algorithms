package longest_increasing_path_in_matrix;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
       Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
        for (int n : nums1)
            s1.add(n);
        for (int n : nums2)
            if(s1.contains(n))
                s2.add(n);
        int r[] = new int[s2.size()], i = 0;
        for (Integer n : s2)
            r[i++] = n;
        return r;
    }
}
