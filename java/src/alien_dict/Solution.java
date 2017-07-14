package alien_dict;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().alienOrder(new String[]{"za", "zb", "ca", "cb"}));
        System.out.println(new Solution().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(new Solution().alienOrder(new String[]{"z", "x"}));
    }

    public String alienOrder(String[] words) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        int[] degree = new int[26];
        String a = "", b;
        for (int i = 0; i < words.length; i++, a = b) {
            b = words[i];
            int j;
            for (j = 0; j < Math.min(a.length(), b.length()); j++) {
                int ib = b.charAt(j) - 'a', ia = a.charAt(j) - 'a';
                if (degree[ib] == 0)
                    degree[ib] = 1;
                if (ib != ia) {
                    if (!g.containsKey(ia))
                        g.put(ia, new HashSet<>());
                    if (g.get(ia).add(ib))
                        degree[ib]++;
                    break;
                }
            }
            for (int k = j; k < b.length(); k++)
                if (degree[b.charAt(k) - 'a'] == 0)
                    degree[b.charAt(k) - 'a'] = 1;
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < degree.length; i++)
            if (degree[i] > 0) {
                count++;
                if (degree[i] == 1)
                    q.add(i);
            }
        StringBuilder alien = new StringBuilder();
        while (!q.isEmpty()) {
            Integer i = q.poll();
            char c = (char) (i + 'a');
            alien.append(c);
            for (int k : g.getOrDefault(i, new HashSet<>())) {
                degree[k]--;
                if (degree[k] == 1)
                    q.add(k);
            }
        }
        return count == alien.length() ? alien.toString() : "";
    }
}
