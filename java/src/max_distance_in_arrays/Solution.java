package max_distance_in_arrays;
import java.util.List;

public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> f = arrays.get(0);
        Integer min = f.get(0), max = f.get(f.size() - 1), r = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> a = arrays.get(i);
            r = Math.max(r, Math.abs(a.get(a.size() - 1) - min));
            r = Math.max(r, max - a.get(0));
            min = Math.min(min, a.get(0));
            max = Math.max(max, a.get(a.size() - 1));
        }
        return r;
    }
}
