package word_abbreviation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().wordsAbbreviation(Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion")));
    }

    public List<String> wordsAbbreviation(List<String> words) {
        Map<String, Map<Integer, String>> groups = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String ab = abbrev(words.get(i), 0);
            if (!groups.containsKey(ab))
                groups.put(ab, new HashMap<>());
            groups.get(ab).put(i, words.get(i));
        }
        for (Map<Integer, String> group : groups.values()) {
            TrieNode trie = new TrieNode();
            for (Integer i : group.keySet()) {
                TrieNode node = trie;
                for (char c : group.get(i).substring(1).toCharArray()) {
                    if (node.children[c - 'a'] == null)
                        node.children[c - 'a'] = new TrieNode();
                    node.count++;
                    node = node.children[c - 'a'];
                }
            }
            for (Integer idx : group.keySet()) {
                TrieNode node = trie;
                int i = 1;
                for (char c : group.get(idx).substring(1).toCharArray()) {
                    if (node.count == 1) break;
                    node = node.children[c - 'a'];
                    i++;
                }
                words.set(idx, abbrev(group.get(idx), i - 1));
            }
        }
        return words;
    }

    String abbrev(String word, int i) {
        int N = word.length();
        if (N - i <= 3) return word;
        return word.substring(0, i + 1) + (N - i - 2) + word.charAt(N - 1);
    }

    class TrieNode {
        final TrieNode[] children = new TrieNode[26];
        int count;
    }
}