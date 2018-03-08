package exclusive_time_of_functions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> s = new ArrayDeque<>();
        int[] time = new int[n];
        for (int prevTime = 0, i = 0; i < logs.size(); i++) {
            String[] parts = logs.get(i).split(":");
            int currTime = Integer.parseInt(parts[2]);
            if (!s.isEmpty())
                time[s.peek()] += currTime - prevTime;
            if (parts[1].equals("start"))
                s.push(Integer.parseInt(parts[0]));
            else {
                time[s.pop()]++;
                currTime++;
            }
            prevTime = currTime;
        }
        return time;
    }
}