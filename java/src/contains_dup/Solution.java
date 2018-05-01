package contains_dup;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] a) {
        Set<Integer> s = new HashSet<>();
        for (int n : a)
            if (!s.add(n))
                return true;
        return false;
    }
}
