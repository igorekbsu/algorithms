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
}
