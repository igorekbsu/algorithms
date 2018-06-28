package clone_graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, UndirectedGraphNode> m = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        if (m.containsKey(node.label))
            return m.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        m.put(node.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors)
            clone.neighbors.add(cloneGraph(neighbor));
        return clone;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
    }
}