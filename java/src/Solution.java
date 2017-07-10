public class Solution {
    public static void main(String[] args) {
        String str = "Hello world igor y";
        ListNode root = new ListNode();
        ListNode node = root;
        for (int i = 0; i < str.length(); i++) {
            node.c = str.charAt(i);
            if (i < str.length() - 1) {
                node.next = new ListNode();
                node = node.next;
            }
        }
        print(root);
        print(reverseWords(root));
    }

    static ListNode reverseWords(ListNode root) {
        ListNode reversed = null, right = root, lastEnd = null;
        while (true) {
            ListNode left = right;
            while (right != null && right.c != ' ')
                right = right.next;
            ListNode r = right;
            while (left != right) {
                ListNode next = left.next;
                left.next = r;
                r = left;
                left = next;
            }
            if (reversed == null) {
                reversed = r;
            } else
                lastEnd.next = r;
            if (right == null) break;
            lastEnd = right;
            right = right.next;
        }
        return reversed;
    }

    static void print(ListNode node) {
        ListNode n = node;
        StringBuilder b = new StringBuilder();
        while (n.next != null) {
            b.append(n.c).append("->");
            n = n.next;
        }
        System.out.println(b.append(n.c));
    }

    static class ListNode {
        Character c;
        ListNode next;
    }
}
