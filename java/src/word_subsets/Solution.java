package word_subsets;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> wordSubsets(String[] a, String[] b) {
        int[] bf = f("");
        for (String s : b)
            for (int i = 0, f[] = f(s); i < 26; i++)
                bf[i] = Math.max(bf[i], f[i]);
        List<String> r = new LinkedList<>();
        next: for (String s : a) {
            for (int i = 0, af[] = f(s); i < 26; i++)
                if (bf[i] > af[i])
                    continue next;
            r.add(s);
        }
        return r;
    }

    int[] f(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray())
            f[c - 'a']++;
        return f;
    }
}
