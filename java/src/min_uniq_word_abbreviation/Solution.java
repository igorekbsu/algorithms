package min_uniq_word_abbreviation;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    int n, cand, bn, minlen, minab;
    List<Integer> dict = new ArrayList<>();

    String minAbbreviation(String target, String[] dictionary) {
        n = target.length(); bn = 1 << n; cand = 0; minlen = Integer.MAX_VALUE;
        StringBuilder res = new StringBuilder();
        for (String s : dictionary) {
            int word = 0;
            if (s.length() != n) continue;
            for (int i = 0; i < n; i++)
                if (target.charAt(i) != s.charAt(i)) word |= 1 << i;
            dict.add(word);
            cand |= word;
        }
        dfs(1, 0);
        for (int i = 0; i < n; )
            if ((minab & (1 << i)) != 0)
                res.append(target.charAt(i++));
            else {
                int j = i;
                while (i < n && (minab & (1 << i)) == 0) i++;
                res.append(i - j);
            }
        return res.toString();
    }

    int abbrLen(int mask) {
        int count = n;
        for (int b = 3; b < bn; b <<= 1)
            if ((mask & b) == 0)
                count--;
        return count;
    }

    void dfs(int bit, int mask) {
        int len = abbrLen(mask);
        if (len >= minlen) return;
        boolean match = true;
        for (Integer d : dict) {
            if ((mask & d) == 0) {
                match = false;
                break;
            }
        }
        if (match) {
            minlen = len;
            minab = mask;
        }
        else {
            for (int b = bit; b < bn; b <<= 1) {
                if ((cand & b) != 0) dfs(b << 1, mask + b);
            }
        }
    }
}
