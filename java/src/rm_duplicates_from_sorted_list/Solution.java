package rm_duplicates_from_sorted_list;
import nub.Nu.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        while (prev.next != null) {
            ListNode node = prev.next;
            int val = node.val;
            if (node.next != null && val == node.next.val) {
                while (node != null && node.val == val)
                    node = node.next;
                prev.next = node;
            } else prev = prev.next;
        }
        return dummy.next;
    }
}
