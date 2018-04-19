package intersection_of_two_linked_list;
import nub.Nu.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if(A == null || B == null)return null;
        ListNode i = A, k = B;
        int count = 0;
        while (count < 2) {
            if (i == null) {
                i = B;
                count++;
            }
            if (k == null)
                k = A;
            i = i.next;
            k = k.next;
            if (i == k) return i;
        }
        return null;
    }
}
