package find_the_closest_palindrome;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().nearestPalindromic("807045053224792883"));
    }

    public String nearestPalindromic(String n) {
        long number = Long.parseLong(n);
        long leftHalf = Long.parseLong(n.substring(0, (n.length() + 1) / 2));
        List<Long> candidates = new ArrayList<>();
        gen(leftHalf - 1, candidates);
        gen((leftHalf - 1) * 10 + 9, candidates);
        gen(leftHalf, candidates);
        gen(leftHalf + 1, candidates);
        gen((leftHalf + 1) / 10, candidates);
        long minDiff = Long.MAX_VALUE, r = 0;
        for (long a : candidates) {
            long diff = Math.abs(a - number);
            if (diff > 0 && (diff < minDiff || (diff == minDiff && a < r))) {
                r = a;
                minDiff = diff;
            }
        }
        return "" + r;
    }

    void gen(long n, List<Long> list) {
        String left = Long.toString(n), right = new StringBuilder(left).reverse().toString();
        try {
            list.add(Long.parseLong(left + right));
            list.add(Long.parseLong(left + right.substring(1)));
        } catch (Exception e) {}
    }
}
