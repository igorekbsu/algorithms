package linked_list;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Node five = new Node(null, 5);
        Node three = new Node(five, 3);
        Node one = new Node(three, 1);
        print(one);
        print(reverse(one));

    }

    static int FindMergeNode(Node a, Node b) {
        Set<Node> aNodes = new HashSet<>();
        while (a != null) {
            aNodes.add(a);
            a = a.next;
        }
        while (b != null) {
            if (aNodes.contains(b)) return b.data;
            b = b.next;
        }
        return 0;
    }

    static void print(Node n) {
        Node a = n;
        while (a != null) {
            System.out.print(a.data + "->");
            a = a.next;
        }
        System.out.println("null");
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node r = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return r;
    }

    static class Node {
        Node next;
        int data;

        Node(Node next, int data) { this.next = next; this.data = data; }

        Node() { }
    }
}
