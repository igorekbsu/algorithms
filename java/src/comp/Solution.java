package comp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        int[][] richer = {
//            {1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}
//        };
        int[][] richer = {{0, 1}, {0, 2}};
        int[] quiet = {0, 1, 2};
        System.out.println(Arrays.toString(new Solution().loudAndRich(richer, quiet)));
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int[] r = new int[quiet.length];
        if (richer.length == 0)
            for (int i = 0; i < quiet.length; i++)
                r[i] = i;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < quiet.length; i++)
            g.put(i, new LinkedList<>());
        for (int[] rich : richer)
            g.get(rich[0]).add(rich[1]);
        int[][] m = new int[quiet.length][quiet.length];
        for (int[] rich : richer)
                dfs(rich[0], rich[1], m, g);
        for (int i = 0; i < r.length; i++) {
            int min = quiet[i];
            r[i] = i;
            for (int j = 0; j < r.length; j++) {
                if (m[j][i] == 1) {
                    if (min > quiet[j]) {
                        min = quiet[j];
                        r[i] = j;
                    }
                }
            }
        }
        return r;
    }

    void dfs(int rich, int poor, int[][] m, Map<Integer, List<Integer>> g) {
        if(m[rich][poor] == 0) {
            m[rich][poor] = 1;
            m[poor][rich] = -1;
            for (int poorer : g.get(poor)) {
                dfs(rich, poorer, m, g);
            }
        }
    }
}
