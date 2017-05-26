public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(-123));
    }

    public int reverse(int x) {
        int r = 0;
        while (x != 0) {
            int d = x % 10;
            r = 10 * r + d;
            x /= 10;
        }
        return r;
    }
}