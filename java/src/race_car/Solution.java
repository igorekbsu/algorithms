package race_car;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int racecar(int target) {
        if (target == 0) return 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1});
        Set<String> used = new HashSet<>();
        used.add(0 + "-" + 1);
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            for (int size = q.size(); size > 0; size--) {
                int[] i = q.poll();
                int p1 = i[0] + i[1], s1 = i[1] * 2;
                if (p1 == target) return count;
                int p2 = i[0], s2 = i[1] > 0 ? -1 : 1;
                q.add(new int[]{p1, s1});
                String key = p2 + "-" + s2;
                if (used.add(key))
                    q.add(new int[]{p2, s2});
            }
        }
        return -1;
    }
}
