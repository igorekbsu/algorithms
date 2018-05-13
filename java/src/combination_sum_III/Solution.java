package combination_sum_III;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> r = new LinkedList<>();
        comb(k, n, 1, new ArrayList<>(k), r);
        return r;
    }

    void comb(int k, int n, int i, List<Integer> list, List<List<Integer>> r) {
        if (k == 0) {
            if (n == 0)
                r.add(new ArrayList<>(list));
        } else
            for (int j = i; j <= 9; j++)
                if (j <= n) {
                    list.add(j);
                    comb(k - 1, n - j, j + 1, list, r);
                    list.remove(list.size() - 1);
                }
    }
}
