package dota2_senate;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> q1 = new ArrayDeque<>(n), q2 = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++)
            if (senate.charAt(i) == 'R') q1.add(i);
            else q2.add(i);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int r = q1.poll(), d = q2.poll();
            if (r < d) q1.add(n + r);
            else q2.add(n + d);
        }
        return q2.isEmpty()? "Radiant": "Dire";
    }
}
