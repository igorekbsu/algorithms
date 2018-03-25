package design_search_autocomplete;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    static class AutocompleteSystem {
        Node trie = new Node(), node = trie;
        StringBuilder s = new StringBuilder();

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++)
                add(sentences[i], times[i]);
        }

        public List<String> input(char c) {
            List<String> r = new LinkedList<>();
            if (c == '#') {
                node.f += 1;
                node.s = s.toString();
                s.setLength(0);
                node = trie;
            } else {
                if (!node.next.containsKey(c))
                    node.next.put(c, new Node());
                node = node.next.get(c);
                s.append(c);
                PriorityQueue<Node> q = new PriorityQueue<>();
                search(node, q);
                for (int i = 0; i < 3 && !q.isEmpty(); i++)
                    r.add(q.poll().s);
            }
            return r;
        }

        void search(Node node, PriorityQueue<Node> q) {
            if (node.f > 0)
                q.add(node);
            for (Node next : node.next.values())
                search(next, q);
        }

        void add(String sentence, int f) {
            Node node = trie;
            for (char c : sentence.toCharArray()) {
                if (!node.next.containsKey(c))
                    node.next.put(c, new Node());
                node = node.next.get(c);
            }
            node.f += f;
            node.s = sentence;
        }

        class Node implements Comparable<Node> {
            Map<Character, Node> next = new HashMap<>();
            int f = 0;
            String s;

            @Override public int compareTo(Node o) {
                return f == o.f ? s.compareTo(o.s) : Integer.compare(o.f, f);
            }
        }
    }
}
