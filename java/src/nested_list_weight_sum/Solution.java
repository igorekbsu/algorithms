package nested_list_weight_sum;
import java.util.List;
import static nub.Nu.NestedInteger;

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depth(nestedList, 1);
    }

    int depth(List<NestedInteger> list, int d) {
        int sum = 0;
        for (NestedInteger n : list)
            if (n.isInteger())
                sum += d * n.getInteger();
            else sum += depth(n.getList(), d + 1);
        return sum;
    }
}