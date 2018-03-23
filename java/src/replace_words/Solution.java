package replace_words;
import java.util.List;

public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Node trie = new Node();
        for (String word : dict) {
            Node node = trie;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null)
                    node.next[c - 'a'] = new Node();
                node = node.next[c - 'a'];
            }
            node.word = word;
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            Node node = trie;
            for (char c : words[i].toCharArray()) {
                node = node.next[c - 'a'];
                if (node == null || node.word != null)
                    break;
            }
            words[i] = node == null || node.word == null ? words[i] : node.word;
        }
        return String.join(" ", words);
    }

    class Node {
        Node[] next = new Node[26];
        String word;
    }
}
