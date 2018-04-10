package bus_routes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] routes = {{1, 2, 3}, {3, 4, 5}, {5, 6}};
        System.out.println(new Solution().numBusesToDestination(routes, 1, 6));
    }

    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        HashSet<Integer> used = new HashSet<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++)
            for (int j = 0; j < routes[i].length; j++) {
                graph.putIfAbsent(routes[i][j], new LinkedList<>());
                graph.get(routes[i][j]).add(i);
            }
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        int r = 1;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--)
                for (int bus : graph.get(q.poll()))
                    if (used.add(bus))
                        for (int j = 0; j < routes[bus].length; j++)
                            if (routes[bus][j] == T)
                                return r;
                            else q.offer(routes[bus][j]);
            r++;
        }
        return -1;
    }
}
