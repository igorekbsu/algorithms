package word_ladder_II;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().findLadders("hot", "dog", Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot")));
    }

    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList), s = new HashSet<>();
        Map<String, List<String>> graph = new HashMap<>();
        List<List<String>> r = new LinkedList<>();
        if (!words.contains(end)) return r;
        s.add(start);
        graph.put(start, new LinkedList<>());
        dfs(s, end, graph, words);
        List<String> path = new LinkedList<>();
        path.add(start);
        collect(start, end, graph, path, r);
        return r;
    }

    void collect(String start, String end, Map<String, List<String>> graph, List<String> path, List<List<String>> r) {
        if (start.equals(end))
            r.add(new ArrayList<>(path));
        else for (String word : graph.getOrDefault(start, new LinkedList<>())) {
            path.add(word);
            collect(word, end, graph, path, r);
            path.remove(path.size() - 1);
        }
    }

    void dfs(Set<String> s, String end, Map<String, List<String>> graph, Set<String> words) {
        boolean done = false;
        words.removeAll(s);
        Set<String> nextWords = new HashSet<>();
        for (String word : s) {
            char[] a = word.toCharArray();
            graph.put(word, new LinkedList<>());
            for (int i = 0; i < a.length; i++) {
                char old = a[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    a[i] = c;
                    String next = new String(a);
                    if (words.contains(next)) {
                        if (next.equals(end))
                            done = true;
                        graph.get(word).add(next);
                        nextWords.add(next);
                    }
                }
                a[i] = old;
            }
        }
        if (!nextWords.isEmpty() && !done)
            dfs(nextWords, end, graph, words);
    }
}
