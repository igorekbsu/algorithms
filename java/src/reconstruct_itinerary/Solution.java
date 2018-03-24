package reconstruct_itinerary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        String[][] tickets = {{"JFK", "SFO"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"JFK", "ATL"}, {"ATL", "SFO"}};
        System.out.println(new Solution().findItinerary(tickets));
    }

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> m = new HashMap<>();
        for (String[] t : tickets) {
            if (!m.containsKey(t[0]))
                m.put(t[0], new PriorityQueue<>());
            m.get(t[0]).add(t[1]);
        }
        return dfs("JFK", m, new LinkedList<>());
    }

    List<String> dfs(String arrival, Map<String, PriorityQueue<String>> m, LinkedList<String> path) {
        PriorityQueue<String> q = m.get(arrival);
        while (q != null && !q.isEmpty())
            dfs(q.poll(), m, path);
        path.addFirst(arrival);
        return path;
    }
}
