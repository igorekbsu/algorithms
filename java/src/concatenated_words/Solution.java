package concatenated_words;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] words = {""};
        System.out.println(new Solution().findAllConcatenatedWordsInADict(words));
    }

    Node root = new Node();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> r = new LinkedList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            if (search(root, 0, chars))
                r.add(word);
            Node node = root;
            for (char c : chars) {
                if (!node.nodes.containsKey(c))
                    node.nodes.put(c, new Node());
                node = node.nodes.get(c);
            }
            node.word = word;
        }
        return r;
    }

    boolean search(Node node, int pos, char[] chars) {
        for (int i = pos; i < chars.length; i++) {
            if (!node.nodes.containsKey(chars[i]))
                return false;
            node = node.nodes.get(chars[i]);
            if (node.word != null)
                if (i + 1 == chars.length || search(root, i + 1, chars))
                    return true;
        }
        return false;
    }

    class Node {
        Map<Character, Node> nodes = new HashMap<>();
        String word;
    }
}
