package copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        node = head;
        while (node != null) {
            RandomListNode copy = map.get(node);
            copy.next = map.get(node.next);
            copy.random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) { this.label = x; }
    }
}
