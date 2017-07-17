package bt_to_cdll;
public class Main {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        Node head = toCdll(root);
        print(head);
    }

    static void print(Node head) {
        System.out.print("(" + head.left + ") ");
        Node node = head;
        do {
            System.out.print(node + " ");
            node = node.right;
        } while (node != head);
    }

    static Node toCdll(Node root) {
        if (root == null) return root;
        Node leftList = toCdll(root.left);
        Node rightList = toCdll(root.right);
        root.left = root.right = root;
        return connect(leftList, connect(root, rightList));
    }

    static Node connect(Node leftList, Node rightList) {
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;
        Node lastLeft = leftList.left;
        Node lastRight = rightList.left;
        lastLeft.right = rightList;
        rightList.left = lastLeft;

        leftList.left = lastRight;
        lastRight.right = leftList;

        return leftList;
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) { this.val = val; }

        @Override public String toString() { return String.valueOf(val); }
    }
}