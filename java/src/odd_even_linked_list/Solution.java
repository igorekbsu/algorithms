package odd_even_linked_list;
import nub.Nu.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = ListNode.create(1, 2, 3, 4);
        System.out.println(head);
        System.out.println(new Solution().oddEvenList(head));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
