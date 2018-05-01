package word_ladder_II;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(new Solution3().findLadders("hot", "dog", Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot")));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList), s = new HashSet<>();
        if (!words.contains(endWord)) return new ArrayList<>();
        Map<String, List<String>> paths = new HashMap<>();
        s.add(beginWord);
        bfs(s, words, paths, endWord);
        List<List<String>> r = new LinkedList<>();
        List<String> path = new LinkedList<>();
        path.add(beginWord);
        collect(beginWord, endWord, paths, path, r);
        return r;
    }

    void collect(String word, String target, Map<String, List<String>> m, List<String> path, List<List<String>> paths) {
        if (word.equals(target))
            paths.add(new ArrayList<>(path));
        else if (m.containsKey(word))
            for (String w : m.get(word)) {
                path.add(w);
                collect(w, target, m, path, paths);
                path.remove(path.size() - 1);
            }
    }

    void bfs(Set<String> s, Set<String> words, Map<String, List<String>> paths, String target) {
        boolean done = false;
        words.removeAll(s);
        Set<String> next = new HashSet<>();
        for (String w : s) {
            char[] chars = w.toCharArray();
            paths.putIfAbsent(w, new LinkedList<>());
            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String nextWord = new String(chars);
                    if (words.contains(nextWord)) {
                        next.add(nextWord);
                        if (nextWord.equals(target))
                            done = true;
                        paths.get(w).add(nextWord);
                    }
                }
                chars[i] = old;
            }
        }
        if (!done && !s.isEmpty())
            bfs(next, words, paths, target);
    }
}
