package nested_list_weight_sum;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static nub.Nu.NestedInteger;

public class Solution {
    public int depthSumIterative(List<NestedInteger> nestedList) {
        int sum = 0, depth = 1;
        Queue<List<NestedInteger>> q = new LinkedList<>();
        q.add(nestedList);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<NestedInteger> elements = q.poll();
                for (NestedInteger element : elements) {
                    if (element.isInteger())
                        sum += element.getInteger() * depth;
                    else q.add(element.getList());
                }
            }
            depth++;
        }
        return sum;
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    int depthSum(List<NestedInteger> nestedList, int depth) {
       int sum = 0;
        for (NestedInteger nestedInteger : nestedList)
            sum+=nestedInteger.isInteger()? nestedInteger.getInteger()*depth:depthSum(nestedInteger.getList(), depth + 1);
        return sum;
    }
}