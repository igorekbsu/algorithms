package reverse_nodes_in_k_group;
import nub.Nu.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        for (ListNode i = head; i != null; len++, i = i.next) ;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (ListNode prev = dummy, tail = head; len >= k; len -= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }
            prev = tail;
            tail = tail.next;
        }
        return dummy.next;
    }
}
