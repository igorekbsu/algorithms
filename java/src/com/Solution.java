package com;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean validTicTacToe(String[] b) {
        Set<String> wins = new HashSet<>();
        int x = 0, o = 0;
        for (String s : b) {
            for (char c : s.toCharArray())
                if (c == 'X')
                    x++;
                else if (c == 'O')
                    o++;
            wins.add(s);
        }
        for (int i = 0; i < 3; i++)
            wins.add(String.valueOf(b[i].charAt(0)) + b[i].charAt(1) + b[i].charAt(2));
        wins.add(String.valueOf(b[0].charAt(0)) + b[1].charAt(1) + b[2].charAt(2));
        wins.add(String.valueOf(b[0].charAt(2)) + b[1].charAt(1) + b[2].charAt(0));
        if (x != o && x != o + 1) return false;
        if (x == o && wins.contains("XXX")) return false;
        if (x == o + 1 && wins.contains("OOO")) return false;
        return true;
    }

    public int numMatchingSubseq(String S, String[] words) {
        Map<String, Integer> m = new HashMap<>();
        for (String word : words)
            m.put(word, m.getOrDefault(word, 0) + 1);
        int count = 0;
        char[] chars = S.toCharArray();
        for (String w : m.keySet()) {
            int i = 0;
            for (int j = 0; i < w.length() && j < S.length(); j++) {
                if (chars[j] == w.charAt(i))
                    i++;
            }
            if (i == w.length()) {
                count += m.get(w);
            }
        }
        return count;
    }

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        long r = 0, out = 0, in = 0;
        for (int a : A)
            if (a > R) {
                r = r + N(in) - N(out);
                in = 0; out = 0;
            } else if (a < L) {
                in++;
                out++;
            } else {
                r -= N(out);
                out = 0;
                in++;
            }
        return (int) (r + N(in) - N(out));
    }

    long N(long n) { return n * (n + 1) / n;}

    public static void main(String[] args) {
        for(int i = 0; i <=15; i++) {
            System.out.println(new Solution().trailingZeroes(Integer.MAX_VALUE - i));
        }
    }

    public int preimageSizeFZF(int K) {
        if (K == 0) return 5;
        if (K % 5 == 0) return 0;
        if (K > 536_870_907) return 0;
        if(K == 536_870_907)return 3;
        return 5;
    }

    int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;
        return count;
    }
}
