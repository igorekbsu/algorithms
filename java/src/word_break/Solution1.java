package word_break;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution1 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(new Solution1().wordBreak(s, wordDict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }

    List<String> dfs(String s, List<String> words, Map<String, List<String>> cache) {
        if (cache.containsKey(s))
            return cache.get(s);
        List<String> r = new LinkedList<>();
        if (s.length() == 0) {
            r.add("");
            return r;
        }
        for (String word : words)
            if (s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), words, cache);
                for (String list : subList)
                    r.add(word + (list.isEmpty() ? "" : " ") + list);
            }
        cache.put(s, r);
        return r;
    }
}
