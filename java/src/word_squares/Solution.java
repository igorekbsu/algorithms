package word_squares;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().wordSquares(new String[]{"area", "lead", "wall", "lady", "ball"}));
    }

    public List<List<String>> wordSquares(String[] words) {
        Map<String, List<String>> m = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String sub = word.substring(0, i);
                if (!m.containsKey(sub))
                    m.put(sub, new ArrayList<>());
                m.get(sub).add(word);
            }
        }
        List<List<String>> r = new LinkedList<>();
        build(1, new ArrayList<>(5), r, Arrays.asList(words), m);
        return r;
    }

    void build(int i, List<String> square, List<List<String>> r, List<String> words, Map<String, List<String>> m) {
        if (words == null) return;
        if (i >= words.get(0).length())
            for (String w : words) {
                square.add(w);
                r.add(new ArrayList<>(square));
                square.remove(square.size() - 1);
            }
        else {
            String pre = "";
            for (String w : square)
                pre += w.charAt(i);
            for (String nextWord : words) {
                square.add(nextWord);
                build(i + 1, square, r, m.get(pre + nextWord.charAt(i)), m);
                square.remove(square.size() - 1);
            }
        }
    }
}
