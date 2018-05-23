package factor_combinations;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> r = new LinkedList<>();
        factors(2, n, new ArrayList<>(), r);
        return r;
    }

    void factors(int start, int n, List<Integer> list, List<List<Integer>> r) {
        for (int i = start; i * i <= n; i++)
            if (n % i == 0) {
                list.add(i);
                factors(i, n / i, list, r);
                list.add(n / i);
                r.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
    }
}
