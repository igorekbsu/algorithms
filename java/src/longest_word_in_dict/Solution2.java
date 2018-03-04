package longest_word_in_dict;
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().longestWord(new String[]{"ap", "pg", "appl"}));
    }

    public String longestWord(String[] words) {
        Node trie = new Node();
        trie.word = "";
        for (String word : words) {
            Node node = trie;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.next[i] == null)
                    node.next[i] = new Node();
                node = node.next[i];
            }
            node.word = word;
        }
        return dfs(trie);
    }

    class Node {
        Node[] next = new Node[26];
        String word;
    }

    String dfs(Node node) {
        String r = node.word;
        for (int i = 0; i < 26; i++)
            if (node.next[i] != null && node.next[i].word != null) {
                String w = dfs(node.next[i]);
                r = w.length() > r.length() ? w : r;
            }
        return r;
    }
}
