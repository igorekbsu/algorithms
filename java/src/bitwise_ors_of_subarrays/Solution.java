package bitwise_ors_of_subarrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().subarrayBitwiseORs(new int[]{1, 2, 3}));
    }
    public int subarrayBitwiseORs(int[] a) {
        Set<Integer> r = new HashSet<>(), s1 = new HashSet<>(), s2;
        for (Integer i : a) {
            s2 = new HashSet<>();
            s2.add(i);
            for (Integer j : s1)
                s2.add(i | j);
            r.addAll(s1 = s2);
        }
        return r.size();
    }
}
