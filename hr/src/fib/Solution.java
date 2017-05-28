package fib;
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(5));
    }

    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;
    }
}
