package trie;
import java.util.HashMap;
import java.util.Map;

public class Trie {
    Node root = new Node();

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++)
            node = node.kids.computeIfAbsent(word.charAt(i), k -> new Node());
        node.isWord = true;
    }

    public boolean search(String word) {
        Node node = find(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String pre) {
        return find(pre) != null;
    }

    Node find(String s) {
        Node node = root;
        for (int i = 0; i < s.length() && node != null; i++)
            node = node.kids.get(s.charAt(i));
        return node;
    }

    class Node {
        Map<Character, Node> kids = new HashMap<>();
        boolean isWord;
    }
}