import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(new Solution().wordBreak(s, dict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet<>(wordDict), 0, new HashMap<>());
    }

    public List<String> word_Break(String s, Set<String> wordDict, int start, Map<Integer, List<String>> cache) {
        if (cache.containsKey(start))
            return cache.get(start);
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length())
            res.add("");
        for (int end = start + 1; end <= s.length(); end++)
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end, cache);
                for (String item : list)
                    res.add(s.substring(start, end) + (item.equals("") ? "" : " ") + item);
            }
        cache.put(start, res);
        return res;
    }
}
