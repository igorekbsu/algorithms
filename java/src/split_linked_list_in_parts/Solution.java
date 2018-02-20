package split_linked_list_in_parts;
import java.util.Arrays;
import nub.Nu.ListNode;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().splitListToParts(ListNode.create(1, 2, 3, 4), 3)));
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        for (ListNode node = root; node != null; len++, node = node.next) ;
        int n = len / k, r = len % k;
        ListNode[] parts = new ListNode[k];
        ListNode node = root;
        for (int i = 0; i < k; i++) {
            parts[i] = node;
            for (int partLen = r-- > 0 ? n : n - 1; partLen > 0; partLen--)
                node = node.next;
            if (node == null) break;
            ListNode next = node.next;
            node.next = null;
            node = next;
        }
        return parts;
    }
}
