package trie;
import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    Node root = new Node();

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++)
            node = node.kids.computeIfAbsent(word.charAt(i), k -> new Node());
        node.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    boolean search(String word, int i, Node node) {
        if (node == null) return false;
        if (i == word.length()) return node.isWord;
        char c = word.charAt(i);
        if (c != '.') {
            return search(word, i + 1, node.kids.get(c));
        } else {
            for (Node kid : node.kids.values())
                if (search(word, i + 1, kid)) return true;
        }
        return false;
    }

    class Node {
        Map<Character, Node> kids = new HashMap<>();
        boolean isWord;
    }
}