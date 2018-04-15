package com;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().p("RRAAA"));
        System.out.println("Target 2:" + new Solution().racecar(2));
        System.out.println("Target 5:" + new Solution().racecar(5));
        System.out.println("Target 3:" + new Solution().racecar(3));
        System.out.println("Target 6:" + new Solution().racecar(6));
    }

    public int p(String str) {
        int p = 0, s = 1;
        for (char c : str.toCharArray())
            if (c == 'A') {
                p += s;
                s *= 2;
            } else s = s > 0 ? -1 : 1;
        return p;
    }

    public int racecar(int t) {
        int p = 0, s = 1, count = 0, prevP = 0;
        while (p < t) {
            count++;
            prevP = p;
            p += s;
            s *= 2;
        }
        if (p == t) return count;
        return count + Math.min(racecar(t - prevP), 1 + racecar(p - t));
    }
}
