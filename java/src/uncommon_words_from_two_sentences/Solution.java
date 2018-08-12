package uncommon_words_from_two_sentences;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] uncommonFromSentences(String a, String b) {
        String[] words = (a + " " + b).split(" ");
        Map<String, Integer> m = new HashMap<>();
        for (String w : words)
            m.put(w, m.getOrDefault(w, 0) + 1);
        List<String> r = new LinkedList<>();
        for (String s : m.keySet())
            if (m.get(s) == 1)
                r.add(s);
        return r.toArray(new String[0]);
    }
}
