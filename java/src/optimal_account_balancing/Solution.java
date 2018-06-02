package optimal_account_balancing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[][] tr = {{10, 11, 6}, {12, 13, 7}, {14, 15, 2}, {14, 16, 2}, {14, 17, 2}, {14, 18, 2}};
        System.out.println(new Solution().minTransfers(tr));
    }

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int[] t : transactions) {
            m.put(t[0], m.getOrDefault(t[0], 0) - t[2]);
            m.put(t[1], m.getOrDefault(t[1], 0) + t[2]);
        }
        return settle(0, new ArrayList<>(m.values()));
    }

    int settle(int start, List<Integer> debt) {
        while (start < debt.size() && debt.get(start) == 0)
            start++;
        if (start == debt.size()) return 0;
        int r = Integer.MAX_VALUE;
        for (int i = start + 1; i < debt.size(); i++)
            if (debt.get(start) * debt.get(i) < 0) {
                debt.set(i, debt.get(i) + debt.get(start));
                r = Math.min(r, 1 + settle(start + 1, debt));
                debt.set(i, debt.get(i) - debt.get(start));
            }
        return r;
    }
}
