package open_the_lock;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (start.equals(target)) return 0;
        Set<String> dead = new HashSet<>(), seen = new HashSet<>();
        Collections.addAll(dead, deadends);
        if (dead.contains(target) || dead.contains(start)) return -1;
        seen.add(start);
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int r = 0;
        while (!q.isEmpty()) {
            r++;
            int size = q.size();
            for (; size > 0; size--) {
                String lock = q.poll();
                Set<String> next = new HashSet<>();
                char[] chars = lock.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char c = chars[i];
                    chars[i] = c == '9' ? '0' : (char) (c + 1);
                    next.add(new String(chars));
                    chars[i] = c == '0' ? '9' : (char) (c - 1);
                    next.add(new String(chars));
                    chars[i] = c;
                }
                for (String s : next)
                    if (s.equals(target)) return r;
                    else if (!dead.contains(s) && seen.add(s))
                        q.add(s);
            }
        }
        return -1;
    }
}
