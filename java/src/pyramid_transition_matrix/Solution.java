package pyramid_transition_matrix;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().pyramidTransition("ABC", Arrays.asList("ABD", "BCE", "DEF", "FFF")));
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> m = new HashMap<>();
        for (String s : allowed) {
            String pre = s.substring(0, 2);
            m.putIfAbsent(pre, new HashSet<>());
            m.get(pre).add(s.charAt(2));
        }
        return bfs(bottom, "", m, 1);
    }

    boolean bfs(String row, String nextRow, Map<String, Set<Character>> allowed, int i) {
        if (row.length() == 1) return true;
        if (nextRow.length() + 1 == row.length())
            return bfs(nextRow, "", allowed, 1);
        for (Character c : allowed.getOrDefault(row.substring(i - 1, i + 1), new HashSet<>()))
            if (bfs(row, nextRow + c, allowed, i + 1))
                return true;
        return false;
    }
}
