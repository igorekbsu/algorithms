package intersection_of_two_arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>(nums1.length), intersect = new HashSet<>();
        for (int n : nums1)
            s.add(n);
        for (int n : nums2)
            if (s.contains(n))
                intersect.add(n);
        int[] r = new int[intersect.size()];
        int i = 0;
        for (int n : intersect)
            r[i++] = n;
        return r;
    }
}
