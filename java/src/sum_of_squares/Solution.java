package sum_of_squares;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(5));
    }

    public boolean judgeSquareSum(int c) {
        int a = 0, b = c;
        while (a <= b) {
            int sqrt = (int) Math.sqrt(b);
            if (sqrt * sqrt == b) return true;
            a++;
            b = c - a * a;
        }
        return false;
    }
}
