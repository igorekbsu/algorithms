package word_search_2;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        char[][] b = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(new Solution().findWords(b, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node trie = new Node();
        for (String word : words) {
            Node node = trie;
            for (char c : word.toCharArray()) {
                if (!node.nodes.containsKey(c))
                    node.nodes.put(c, new Node());
                node = node.nodes.get(c);
            }
            node.word = word;
        }
        List<String> r = new LinkedList<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                visit(board, i, j, trie, r);
        return r;
    }

    void visit(char[][] board, int i, int j, Node node, List<String> r) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        node = node.nodes.get(c);
        if (node == null || c == '-') return;
        else if (node.word != null) {
            r.add(node.word);
            node.word = null;
        }
        board[i][j] = '-';
        visit(board, i, j - 1, node, r);
        visit(board, i, j + 1, node, r);
        visit(board, i + 1, j, node, r);
        visit(board, i - 1, j, node, r);
        board[i][j] = c;
    }

    class Node {
        Map<Character, Node> nodes = new HashMap<>();
        String word;
    }
}