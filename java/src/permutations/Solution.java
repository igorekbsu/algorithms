package permutations;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
    public List<List<Integer>> permute(int[] num) {
        LinkedList<List<Integer>> perms = new LinkedList<>();
        perms.add(new ArrayList<>());
        for (int n : num) {
            int size = perms.size();
            for (; size > 0; size--) {
                List<Integer> p = perms.pollFirst();
                for (int i = 0; i <= p.size(); i++) {
                    List<Integer> next = new ArrayList<>(p);
                    next.add(i, n);
                    perms.add(next);
                }
            }
        }
        return perms;
    }
}
