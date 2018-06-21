package k_similar_strs;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(A);
        seen.add(A);
        int r = 0;
        while (!q.isEmpty()) {
            r++;
            for (int size = q.size(); size > 0; size--) {
                String s = q.poll();
                int i = 0;
                while (s.charAt(i) == B.charAt(i))
                    i++;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == B.charAt(j) || s.charAt(i) != B.charAt(j))
                        continue;
                    String tmp = swap(s, i, j);
                    if (tmp.equals(B))
                        return r;
                    if (seen.add(tmp))
                        q.add(tmp);
                }
            }
        }
        return r;
    }

    String swap(String s, int i, int j) {
        char[] r = s.toCharArray();
        char t = r[i];
        r[i] = r[j];
        r[j] = t;
        return new String(r);
    }
}
