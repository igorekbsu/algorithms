package min_genetic_mutation;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int minMutation(String start, String end, String[] b) {
        char[] seq = "ACGT".toCharArray();
        Set<String> bank = new HashSet<>(), seen = new HashSet<>();
        Collections.addAll(bank, b);
        if (!bank.contains(end)) return -1;
        int d = 0;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            d++;
            int size = q.size();
            for (; size > 0; size--) {
                char[] a = q.poll().toCharArray();
                for (int i = 0; i < a.length; i++)
                    for (char c : seq)
                        if (a[i] != c) {
                            char old = a[i];
                            a[i] = c;
                            String next = new String(a);
                            if (next.equals(end)) return d;
                            if (seen.add(next) && bank.contains(next))
                                q.add(next);
                            a[i] = old;
                        }
            }
        }
        return -1;
    }
}
