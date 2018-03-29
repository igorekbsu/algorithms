package insertion_sort_list;
import nub.Nu.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create(2, 1);
        System.out.println(new Solution().insertionSortList(listNode));
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0), pre, curr = head;
        while (curr != null) {
            pre = dummy;
            while (pre.next != null && pre.next.val < curr.val)
                pre = pre.next;
            ListNode next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
        }
        return dummy.next;
    }
}