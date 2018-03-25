package implement_trie;
public class Solution {
    class Trie {
        Node trie = new Node();

        public void insert(String word) {
            Node node = trie;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null)
                    node.next[c - 'a'] = new Node();
                node = node.next[c - 'a'];
            }
            node.word = true;
        }

        public boolean search(String word) {
            Node node = find(word);
            return node != null && node.word;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) != null;
        }

        Node find(String word) {
            Node node = trie;
            for (char c : word.toCharArray()) {
                node = node.next[c - 'a'];
                if (node == null) return null;
            }
            return node;
        }

        class Node {
            final Node[] next = new Node[26];
            boolean word;
        }
    }
}
