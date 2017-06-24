package course_schedule;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++)
            graph.put(i, new LinkedList<>());
        for (int[] p : prerequisites) {
            degree[p[1]]++;
            graph.get(p[0]).add(p[1]);
        }
        for (int i = 0; i < degree.length; i++)
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        while (queue.size() != 0) {
            int course = queue.poll();
            List<Integer> adj = graph.get(course);
            if (adj != null)
                for (Integer a : adj) {
                    degree[a]--;
                    if (degree[a] == 0) {
                        queue.add(a);
                        count++;
                    }
                }
        }
        return count == numCourses;
    }
}