package bst;
import java.util.*;

public class Main {
    static Node NULL = new Node();
    static {
        NULL.right = NULL;
        NULL.left = NULL;
    }

    public static void main(String[] args) {
        Node zero = new Node(0, NULL, NULL);
        Node one = new Node(1, NULL, zero);
        Node two = new Node(2, NULL, NULL);
        Node three = new Node(3, NULL, NULL);
        Node four = new Node(4, one, two);
        Node six = new Node(6, three, NULL);
        Node five = new Node(50, four, six);
        print(five);
    }

    static void print(Node node) {
        int h = height(node);
        int b = (int) Math.pow(2, h);
        int w = 3 * b - 1;
        char[][] grid = new char[h + 1][w];
        for (char[] row : grid) Arrays.fill(row, ' ');
        List<Node> nodes = new ArrayList<>();
        nodes.add(node);
        for (int level = 0; level < 4; level++) {
            int childCount = (int) Math.pow(2, level);
            int nodeWidth = w / childCount;
            int start = 0;
            List<Node> children = new ArrayList<>();
            for (Node n : nodes) {
                if (n != NULL) {
                    printNode(n, grid, start, start + nodeWidth, level);
                }
                start += nodeWidth + 1;
                children.add(n.left);
                children.add(n.right);
            }
            nodes = children;
        }
        print(grid);
    }

    static void printNode(Node node, char[][] grid, int s, int e, int level) {
        int middle = (e + s) / 2;
        int q = (e - s) / 4;
        if (node.left != NULL)
            Arrays.fill(grid[level], middle - q, middle, '_');
        if (node.right != NULL)
            Arrays.fill(grid[level], middle + 1, middle + q + 1, '_');
        String d = Integer.toString(node.d);
        for (int i = 0; i < d.length(); i++)
            grid[level][middle + i] = d.charAt(i);
    }

    static void print(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                System.out.print(grid[i][j]);
            System.out.println();
        }
    }

    static int height(Node node) {
        if (node == NULL) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static class Node {
        int d;
        Node left, right;

        public Node() { }

        Node(int d, Node left, Node right) {
            this.d = d;
            this.left = left;
            this.right = right;
        }

        @Override public String toString() { return Integer.toString(d); }
    }
}
