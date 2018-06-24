package reverse_linked_list;
import nub.Nu.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode list = ListNode.create(1, 2);
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
