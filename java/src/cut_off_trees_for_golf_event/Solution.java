package cut_off_trees_for_golf_event;
import nub.Nu.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode list = ListNode.create(1, 2, 3);
        System.out.println(list);
        System.out.println(new Solution().reverse(list));
    }

    public ListNode reverse(ListNode head) {
        ListNode a = null, b = head;
        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }
}
