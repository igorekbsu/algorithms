package nub;
import java.util.LinkedList;
import java.util.List;

public class Nu {
    public static class NestedInteger {
        int val;
        List<NestedInteger> list;

        public NestedInteger(int val) {
            this.val = val;
        }

        public NestedInteger() {
            list = new LinkedList<>();
        }

        public void add(NestedInteger ni) { list.add(ni);}

        public boolean isInteger() { return list == null;}

        public Integer getInteger() {return val;}

        public List<NestedInteger> getList() {return list;}
    }

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int x) { val = x; }
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) { val = x; }

        @Override public String toString() {
            StringBuilder b = new StringBuilder();
            ListNode n = this;
            while (n.next != null) {
                b.append(n.val).append("->");
                n = n.next;
            }
            b.append(n.val);
            return b.toString();
        }

        public static ListNode create(int... values) {
            ListNode head = new ListNode(values[0]);
            ListNode node = head;
            for (int i = 1; i < values.length; i++) {
                node.next = new ListNode(values[i]);
                node = node.next;
            }
            return head;
        }
    }

    public static class Interval {
        public int start, end;

        public Interval() { start = 0; end = 0; }

        public Interval(int s, int e) { start = s; end = e; }

        @Override public String toString() { return "[" + start + "," + end + "]";}
    }

    public static void print(int[][] m) {
        for (int[] r : m) {
            for (int e : r)
                System.out.print(e);
            System.out.println();
        }
    }
}
