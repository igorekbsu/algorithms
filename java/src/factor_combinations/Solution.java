package factor_combinations;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> r = new ArrayList<>();
        factors(r, new ArrayList<>(), n, 2);
        return r;
    }

    void factors(List<List<Integer>> r, List<Integer> list, int n, int start) {
        if (n <= 1) {
            if (list.size() > 1)
                r.add(new ArrayList<>(list));
        } else for (int i = start; i <= n; i++)
            if (n % i == 0) {
                list.add(i);
                factors(r, list, n / i, i);
                list.remove(list.size() - 1);
            }
    }
}
