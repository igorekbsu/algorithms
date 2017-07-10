package perfect_square;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(808201));
    }

    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = num / 2;
        while (lo < hi) {
            int m = (hi + lo) / 2;
            long squared = (long) m * m;
            if (squared == num) return true;
            else if (squared < num) {
                lo = m + 1;
            } else
                hi = m - 1;
        }
        return (long) lo * lo == num;
    }
}
