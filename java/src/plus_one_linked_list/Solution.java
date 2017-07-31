package plus_one_linked_list;
import nub.Nu.ListNode;

public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode f = dummy, node = head;
        while (node != null) {
            if (node.val != 9)
                f = node;
            node = node.next;
        }
        node = f.next;
        while (node != null) {
            node.val = 0;
            node = node.next;
        }
        f.val++;
        if (f != dummy)
            return head;
        return f;
    }
}
