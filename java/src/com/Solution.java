package com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    Map<String, Double> cache = new HashMap<>();

    public double largestSumOfAverages(int[] A, int K) {
        return largest(A, K, 0);
    }

    double largest(int[] a, int k, int start) {
        String key = start + "-" + k;
        if (cache.containsKey(key))
            return cache.get(key);
        if (k == 1) {
            double sum = 0, len = 0;
            for (int i = start; i < a.length; i++, len++)
                sum += a[i];
            if (len == 0) return 0;
            return sum / len;
        }
        int sum = 0;
        double largest = 0, len = 1;
        for (int i = start; i < a.length; i++, len++) {
            sum += a[i];
            largest = Math.max(largest, sum / len + largest(a, k - 1, i + 1));
        }
        cache.put(key, largest);
        return largest;
    }

    public static void main(String[] args) {
        int[][] routes = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        System.out.println(new Solution().numBusesToDestination(routes, 15, 12));
    }

    public int numBusesToDestination(int[][] routes, int s, int t) {
        List<Set<Integer>> graph = new ArrayList<>(routes.length);
        List<Integer> startBuses = new LinkedList<>();
        for (int i = 0; i < routes.length; i++) {
            Set<Integer> stops = new HashSet<>();
            for (int stop : routes[i])
                stops.add(stop);
            graph.add(stops);
            if (stops.contains(s))
                startBuses.add(i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < startBuses.size(); i++) {
            Set<Integer> used = new HashSet<>();
            used.add(i);
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            int n = 1;
            boolean done = false;
            while (!q.isEmpty()) {
                for (int size = q.size(); size > 0; size--) {
                    Integer bus = q.poll();
                    Set<Integer> stops = graph.get(bus);
                    if (stops.contains(t)) {
                        done = true;
                        break;
                    }
                    for (int j = 0; j < graph.size(); j++)
                        if (!used.contains(j))
                            for (Integer stop : stops)
                                if (graph.get(j).contains(stop)) {
                                    q.add(j);
                                    used.add(j);
                                }
                }
                if (done) break;
                n++;
            }
            if (done)
                min = Math.min(min, n);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
