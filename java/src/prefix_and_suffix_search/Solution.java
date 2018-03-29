package prefix_and_suffix_search;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        WordFilter f = new WordFilter(new String[]{"abbbababbb","baaabbabbb","abababbaaa","abbbbbbbba","bbbaabbbaa","ababbaabaa","baaaaabbbb","babbabbabb","ababaababb","bbabbababa"});
        System.out.println(f.f("", "abaa"));
    }

    static class WordFilter {
        final Map<String, List<Integer>> pm = new HashMap<>(), sm = new HashMap<>();

        public WordFilter(String[] words) {
            Map<String, Integer> m = new HashMap<>();
            for (int i = 0; i < words.length; i++)
                m.put(words[i], i);
            for (String w : m.keySet()) {
                for (int j = 0; j <= w.length(); j++) {
                    String p = w.substring(0, j), s = w.substring(j);
                    if (!pm.containsKey(p))
                        pm.put(p, new LinkedList<>());
                    if (!sm.containsKey(s))
                        sm.put(s, new LinkedList<>());
                    pm.get(p).add(m.get(w));
                    sm.get(s).add(m.get(w));
                }
            }
        }

        public int f(String prefix, String suffix) {
            List<Integer> l1 = pm.get(prefix), l2 = sm.get(suffix);
            if (l1 == null || l2 == null)
                return -1;
            for (int i = l1.size() - 1, j = l2.size() - 1; i >= 0 && j >= 0; )
                if (l1.get(i) > l2.get(j))
                    i--;
                else if (l1.get(i) < l2.get(j))
                    j--;
                else return l1.get(i);
            return -1;
        }
    }
}