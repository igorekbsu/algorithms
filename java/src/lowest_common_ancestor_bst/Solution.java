package lowest_common_ancestor_bst;
public class Solution {
    class Trie {
        Node trie = new Node();

        public void insert(String word) {
            Node node = trie;
            for (char c : word.toCharArray()) {
                if (node.nodes[c - 'a'] == null)
                    node.nodes[c - 'a'] = new Node();
                node = node.nodes[c - 'a'];
            }
            node.word = true;
        }

        public boolean search(String word) {
            Node node = find(word);
            return node != null && node.word;
        }

        public boolean startsWith(String prefix) { return find(prefix) != null;}

        public Node find(String pre) {
            Node node = trie;
            for (char c : pre.toCharArray()) {
                node = node.nodes[c - 'a'];
                if (node == null) return null;
            }
            return node;
        }

        class Node {
            final Node[] nodes = new Node[26];
            boolean word;
        }
    }
}
