package most_common_word;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(".sdfsdf,sdfsdf".replaceAll("[.,]", ""));
    }

    public String mostCommonWord(String p, String[] banned) {
        String[] words = p.replaceAll("[!?',;.]", "").split("\\s+");
        Set<String> s = new HashSet<>(Arrays.asList(banned));
        int maxCount = 0;
        Map<String, Integer> counts = new HashMap<>();
        String r = "";
        for (String word : words) {
            word = word.toLowerCase();
            if (!s.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
                if (counts.get(word) > maxCount) {
                    maxCount = counts.get(word);
                    r = word;
                }
            }
        }
        return r;
    }
}
