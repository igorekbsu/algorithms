package bst;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(6);
        for (int i = 1; i <= 9; i++) {
            insert(root, i);
            insert(root, 9 - i);
            insert(root, 9);
            insert(root, 2);
            insert(root, 3);
        }
        print(root);
    }

    static void insert(Node root, int i) {
        Node newNode = new Node(i);
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (node.left == null) {
                node.left = newNode;
                return;
            } else if (node.right == null) {
                node.right = newNode;
                return;
            }
            nodes.add(node.left);
            nodes.add(node.right);
        }
    }

    static void print(Node node) {
        int h = height(node);
        int b = (int) Math.pow(2, h);
        int w = 3 * b - 1;
        char[][] grid = new char[h + 1][w];
        for (char[] row : grid) Arrays.fill(row, ' ');
        List<Node> nodes = new ArrayList<>();
        nodes.add(node);
        for (int level = 0; level <= h; level++) {
            int childCount = (int) Math.pow(2, level);
            int nodeWidth = w / childCount;
            int start = 0;
            List<Node> children = new ArrayList<>();
            for (Node n : nodes) {
                if (n != null) {
                    printNode(n, grid, start, start + nodeWidth, level);
                }
                start += nodeWidth + 1;
                children.add(n == null ? null : n.left);
                children.add(n == null ? null : n.right);
            }
            nodes = children;
        }
        print(grid);
    }

    static void printNode(Node node, char[][] grid, int s, int e, int level) {
        int middle = (e + s) / 2;
        int q = (e - s) / 4;
        if (node.left != null)
            Arrays.fill(grid[level], middle - q, middle, '_');
        if (node.right != null)
            Arrays.fill(grid[level], middle + 1, middle + q + 1, '_');
        String d = Integer.toString(node.d);
        for (int i = 0; i < d.length(); i++)
            grid[level][middle + i] = d.charAt(i);
    }

    static void print(char[][] grid) {
        for (char[] row : grid) {
            for (char e : row) System.out.print(e);
            System.out.println();
        }
    }

    static int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static class Node {
        int d;
        Node left, right;

        Node(int d) { this.d = d; }

        @Override public String toString() { return Integer.toString(d); }
    }
}
