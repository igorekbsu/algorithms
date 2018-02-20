package add_two_numbers;
import java.util.Stack;
import nub.Nu.ListNode;

public class Solution2 {
    public static void main(String[] args) {
        ListNode r = new Solution2().addTwoNumbers(ListNode.create(1, 2), ListNode.create(9, 9, 9));
        System.out.println(r);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode r = new ListNode(0);
        int carry = 0;
        while (!s1.isEmpty() || !s2.empty()) {
            if (!s1.isEmpty()) carry += s1.pop();
            if (!s2.isEmpty()) carry += s2.pop();
            r.val = carry % 10;
            ListNode head = new ListNode(carry = (carry / 10));
            head.next = r;
            r = head;
        }
        return r.val == 0 ? r.next : r;
    }
}
