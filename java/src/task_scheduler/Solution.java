package task_scheduler;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().leastInterval(new char[]{'A', 'A', 'B'}, 1));
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> f = new HashMap<>();
        for (char task : tasks)
            f.put(task, f.getOrDefault(task, 0) + 1);
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        q.addAll(f.values());
        int r = 0, cycle = n + 1;
        while (!q.isEmpty()) {
            int time = 0;
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < cycle; i++)
                if (!q.isEmpty()) {
                    tmp.add(q.poll());
                    time++;
                }
            for (Integer count : tmp)
                if (--count > 0)
                    q.offer(count);
            r += !q.isEmpty() ? cycle : time;
        }
        return r;
    }
}
