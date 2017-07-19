package nub;
import java.util.List;

public class Nu {
    public interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
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
    }

    public static class Interval {
        public int start, end;

        public Interval() { start = 0; end = 0; }

        public Interval(int s, int e) { start = s; end = e; }
    }
}
