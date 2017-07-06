package shortest_palindrome;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestPalindrome("daabaan"));
        System.out.println(new Solution().shortestPalindrome("abcd"));
    }

    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) == s.charAt(j))
                j++;
        if (j == s.length()) return s;
        String suffix = s.substring(j);
        return new StringBuilder(suffix).reverse() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
}
