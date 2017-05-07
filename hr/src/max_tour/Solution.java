package max_tour;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new FileInputStream("hr/src/in1"));
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, Set<Integer>> route = new HashMap<>();
        for (int i = 1; i <= n; i++)
            route.put(i, new HashSet<>());
        for (int i = 0; i < m; i++) {
            int a = in.nextInt(), b = in.nextInt();
            route.get(a).add(b);
            route.get(b).add(a);
        }
        int max = 0;
        Set<Integer> visited = new HashSet<>();
        for (int t = 1; t <= n; t++) {
            if (route.containsKey(t)) {
                int count = visit(t, route, visited);
                if (count > max) max = count;
            }
        }
        System.out.println(max);
    }

    static int visit(int t, Map<Integer, Set<Integer>> route, Set<Integer> visited) {
        if (visited.add(t)) {
            int count = 1;
            if (route.get(t) != null)
                for (int i : route.get(t))
                    count += visit(i, route, visited);
            return count;
        }
        return 0;
    }
}