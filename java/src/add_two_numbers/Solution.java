package add_two_numbers;
import nub.Nu.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = new ListNode(0), node = r;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(carry % 10);
            node = node.next;
            carry /= 10;
        }
        if (carry > 0)
            node.next = new ListNode(carry);
        return r.next;
    }
}
