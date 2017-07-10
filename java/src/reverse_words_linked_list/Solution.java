package reverse_words_linked_list;
public class Solution {
    public static void main(String[] args) {
        String words = "no";
        ListNode root = new ListNode();
        ListNode node = root;
        for (int i = 0; i < words.length(); i++) {
            node.c = words.charAt(i);
            if (i != words.length() - 1) {
                ListNode next = new ListNode();
                node.next = next;
                node = next;
            }
        }
        print(root);
        print(reverseWords(root));
    }

    static ListNode reverseWords(ListNode root) {
        ListNode reverseHead = null, right = root, lastEnd = null;
        while (true) {
            ListNode left = right;
            while (right != null && right.c != ' ')
                right = right.next;
            ListNode reversed = right;
            while (left != right) {
                ListNode next = left.next;
                left.next = reversed;
                reversed = left;
                left = next;
            }
            if (reverseHead == null)
                reverseHead = reversed;
            else
                lastEnd.next = reversed;
            if (right == null) {
                break;
            } else {
                lastEnd = right;
                right = right.next;
            }
        }
        return reverseHead;
    }

    static void print(ListNode root) {
        StringBuilder b = new StringBuilder();
        ListNode node = root;
        while (node != null) {
            b.append(node.c).append("->");
            node = node.next;
        }
        System.out.println(b.append("nil"));
    }

    static class ListNode {
        Character c;
        ListNode next;

        @Override public String toString() {
            return String.valueOf(c);
        }
    }
}
