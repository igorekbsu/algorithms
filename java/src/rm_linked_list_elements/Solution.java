package rm_linked_list_elements;
import nub.Nu.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            while (next != null && next.val == val)
                next = next.next;
            node.next = next;
            node = node.next;
        }
        return head;
    }
}
