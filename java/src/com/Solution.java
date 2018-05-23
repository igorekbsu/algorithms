package com;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().pushDominoes(".R..L."));
        System.out.println(new Solution().pushDominoes("L.LL......"));
        System.out.println(new Solution().pushDominoes(".L"));
        System.out.println(new Solution().pushDominoes("R."));
        System.out.println(new Solution().pushDominoes("L.....RR.RL.....L.R."));
    }

    public String pushDominoes(String dominoes) {
        if (dominoes.isEmpty()) return "";
        char[] a = dominoes.toCharArray();
        int L = -1, R = -1;
        for (int i = 0; i <= dominoes.length(); i++)
            if (i == a.length || a[i] == 'R') {
                if (R > L)
                    while (R < i)
                        a[R++] = 'R';
                R = i;
            } else if (a[i] == 'L') {
                if (L > R || (R == -1 && L == -1))
                    while (++L < i)
                        a[L] = 'L';
                else {
                    L = i;
                    int lo = R + 1, hi = L - 1;
                    while (lo < hi) {
                        a[lo++] = 'R';
                        a[hi--] = 'L';
                    }
                }
            }
        return new String(a);
    }
}
