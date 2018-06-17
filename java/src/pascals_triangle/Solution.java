package pascals_triangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
    }
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> r = new ArrayList<>(n);
        if (n == 0) return r;
        r.add(Arrays.asList(1));
        for (int i = 1; i < n; i++) {
            List<Integer> row = new ArrayList<>(i + 1), prev = r.get(i - 1);
            row.add(1);
            for (int j = 1; j < prev.size(); j++)
                row.add(prev.get(j - 1) + prev.get(j));
            row.add(1);
            r.add(row);
        }
        return r;
    }
}
