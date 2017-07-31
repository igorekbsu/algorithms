package nested_list_weight_sum_2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import nub.Nu.NestedInteger;

public class Solution {
    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger(1));
        nestedList.add(new NestedInteger());
        nestedList.get(1).add(new NestedInteger(2));
        System.out.println(new Solution().depthSumInverse(nestedList));
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int total = 0, level = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> next = new LinkedList<>();
            for (NestedInteger i : nestedList) {
                if (i.isInteger())
                    level += i.getInteger();
                else next.addAll(i.getList());
            }
            total += level;
            nestedList = next;
        }
        return total;
    }
}
