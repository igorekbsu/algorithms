package convert_sorted_list_to_bst;
import nub.Nu.ListNode;
import nub.Nu.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return bst(head, null);
    }

    TreeNode bst(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = bst(head, slow);
        node.right = bst(slow.next, tail);
        return node;
    }
}
