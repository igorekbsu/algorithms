package word_ladder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        System.out.print(new Solution2().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }

    public List<List<String>> findLadders(String w1, String w2, List<String> wordList) {
        if (!wordList.contains(w2)) return new LinkedList<>();
        Map<String, List<String>> g = new HashMap<>();
        Set<String> visited = new HashSet<>();
        visited.add(w1);
        Queue<String> q = new LinkedList<>();
        q.add(w1);
        boolean done = false;
        int d = 1;
        while (!q.isEmpty() && !done) {
            int size = q.size();
            List<String> next = new LinkedList<>();
            for (; size > 0; size--) {
                String word = q.poll();
                g.put(word, new LinkedList<>());
                for (String nextWord : wordList) {
                    if (!visited.contains(nextWord)) {
                        int diff = 0;
                        for (int i = 0; i < word.length(); i++)
                            if (word.charAt(i) != nextWord.charAt(i)) {
                                diff++;
                                if (diff > 1) break;
                            }
                        if (diff == 1) {
                            g.get(word).add(nextWord);
                            q.add(nextWord);
                            next.add(nextWord);
                            if (nextWord.equals(w2))
                                done = true;
                        }
                    }                                                                           
                }
            }
            visited.addAll(next);
            d++;
        }
        List<List<String>> r = new LinkedList<>();
        bfs(g, w1, w2, r, d, new LinkedList<>());
        return r;
    }

    void bfs(Map<String, List<String>> g, String w1, String w2, List<List<String>> r, int d, List<String> c) {
        c.add(w1);
        if (w1.equals(w2))
            if (d == c.size())
                r.add(c);
        if (c.size() >= d) return;
        for (String w : g.get(w1))
            bfs(g, w, w2, r, d, new LinkedList<>(c));
    }
}
