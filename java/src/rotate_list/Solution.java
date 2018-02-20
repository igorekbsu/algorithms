package rotate_list;
import nub.Nu.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 1;
        ListNode node = head;
        for (; node.next != null; len++, node = node.next) ;
        k = k % len;
        node.next = head;
        for (int i = 0; i < len - k; i++)
            node = node.next;
        head = node.next;
        node.next = null;
        return head;
    }
}
