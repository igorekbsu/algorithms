package merge_two_sorted_list;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().merge(Arrays.asList(1, 2, 4), Arrays.asList(0, 0, 1, 2, 3)));
    }

    public List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> r = new ArrayList<>(l1.size() + l2.size());
        int i1 = 0, i2 = 0;
        while (i1 < l1.size() && i2 < l2.size())
            if (l1.get(i1) < l2.get(i2))
                r.add(l1.get(i1++));
            else r.add(l2.get(i2++));
        while (i1 < l1.size())
            r.add(l1.get(i1++));
        while (i2 < l2.size())
            r.add(l2.get(i2++));
        return r;
    }
}
