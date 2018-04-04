package word_ladder_II;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findLadders("hot", "dog", Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot")));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList), s1 = new HashSet<>(), s2 = new HashSet<>();
        if (!words.contains(endWord))
            return new ArrayList<>();
        Map<String, List<String>> paths = new HashMap<>();
        s1.add(beginWord);
        s2.add(endWord);
        dfs(s1, s2, words, paths, true);
        List<List<String>> r = new LinkedList<>();
        populateResult(beginWord, endWord, paths, new LinkedList<>(Arrays.asList(beginWord)), r);
        return r;
    }

    void populateResult(String w1, String w2, Map<String, List<String>> paths, List<String> list, List<List<String>> r) {
        if (w1.equals(w2))
            r.add(new ArrayList<>(list));
        if (paths.get(w1) != null)
            for (String w : paths.get(w1)) {
                list.add(w);
                populateResult(w, w2, paths, list, r);
                list.remove(list.size() - 1);
            }
    }

    void dfs(Set<String> s1, Set<String> s2, Set<String> words, Map<String, List<String>> paths, boolean dir) {
        if (s1.isEmpty()) return;
        if (s1.size() > s2.size()) {
            dfs(s2, s1, words, paths, !dir);
            return;
        }
        words.removeAll(s1);
        words.removeAll(s2);
        Set<String> next = new HashSet<>();
        boolean done = false;
        for (String w : s1) {
            char[] a = w.toCharArray();
            for (int i = 0; i < a.length; i++) {
                char old = a[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    a[i] = c;
                    String str = new String(a);
                    if (s2.contains(str)) {
                        done = true;
                        add(paths, w, str, dir);
                    }
                    if (words.contains(str)) {
                        add(paths, w, str, dir);
                        next.add(str);
                    }
                }
                a[i] = old;
            }
        }
        if (!done)
            dfs(next, s2, words, paths, dir);
    }

    void add(Map<String, List<String>> paths, String key, String val, boolean dir) {
        String k, v;
        if (dir) {
            k = key;
            v = val;
        } else {
            k = val;
            v = key;
        }
        if (!paths.containsKey(k))
            paths.put(k, new ArrayList<>(2));
        paths.get(k).add(v);
    }
}
