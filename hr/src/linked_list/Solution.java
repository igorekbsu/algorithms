package linked_list;
public class Solution {
    public static void main(String[] args) {
        Node head = new Node(null, 5);
        head = new Node(head, 3);
        head = new Node(head, 1);
        print(head);
        print(reverse(head));
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
