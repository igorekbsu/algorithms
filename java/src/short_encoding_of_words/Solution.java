package short_encoding_of_words;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> s = new HashSet<>(Arrays.asList(words));
        for (String w : words)
            for (int i = 1; i < w.length(); i++)
                s.remove(w.substring(i));
        int len = 0;
        for (String w : s)
            len += w.length() + 1;
        return len;
    }

    public static void main(String[] args) {
        String[] words = {"me", "time"};
        System.out.println(new Solution().minimumLengthEncoding1(words));
    }

    public int minimumLengthEncoding1(String[] words) {
        Node trie = new Node();
        Set<Node> nodes = new HashSet<>();
        for (String w : words) {
            Node node = trie;
            for (int i = w.length() - 1; i >= 0; i--)
                node = node.add(w.charAt(i));
            node.depth = w.length() + 1;
            nodes.add(node);
        }
        return nodes.stream().filter(n -> n.leaf).mapToInt(n -> n.depth).sum();
    }

    class Node {
        final Node[] next = new Node[26];
        boolean leaf = true;
        int depth;

        Node add(char c) {
            if (next[c - 'a'] == null)
                next[c - 'a'] = new Node();
            leaf = false;
            return next[c - 'a'];
        }
    }
}
