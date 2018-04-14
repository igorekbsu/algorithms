package kill_process;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            m.putIfAbsent(ppid.get(i), new LinkedList<>());
            m.get(ppid.get(i)).add(pid.get(i));
        }
        LinkedList<Integer> r = new LinkedList<>(), q = new LinkedList<>();
        q.add(kill);
        while (!q.isEmpty()) {
            Integer p = q.poll();
            r.add(p);
            if (m.containsKey(p))
                q.addAll(m.get(p));
        }
        return r;
    }
}
