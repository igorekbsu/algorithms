package delete_node_in_linked_list;
import nub.Nu.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
