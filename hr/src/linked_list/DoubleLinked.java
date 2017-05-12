package linked_list;

public class DoubleLinked {
    public static void main(String[] args) {
        Node three = new Node(3, null, null);
        Node two = new Node(2, null, three);
        Node one = new Node(1, null, two);
        three.prev = two;
        two.prev = one;
        print(one);
        print(reverse(one));
    }

    static Node reverse(Node head) {
        Node n = head, r = head;
        while(n != null){
            Node next = n.next;
            n.next = n.prev;
            n.prev = next;
            r = n;
            n = next;
        }
        return r;
    }

    static void print(Node n) {
        while (n.next != null) {
            System.out.print(n.d + "->");
            n = n.next;
        }
        System.out.print(n.d + ";");
        while (n.prev != null) {
            System.out.print(n.d + "->");
            n = n.prev;
        }
        System.out.println(n.d);
    }

    static class Node {
        int d;
        Node prev, next;

        public Node(int d, Node prev, Node next) {
            this.d = d;
            this.prev = prev;
            this.next = next;
        }

        @Override public String toString() {return Integer.toString(d); }
    }
}
