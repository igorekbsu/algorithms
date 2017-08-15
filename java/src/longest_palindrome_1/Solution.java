package longest_palindrome_1;
public class Solution {
    public int longestPalindrome(String s) {
        int[] f = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c))
                f[c - 'A' + 26]++;
            else
                f[c - 'a']++;
        }
        int len = 0, oddCount = 0;
        for (int n : f)
            if (n % 2 == 1) {
                len += n - 1;
                oddCount += n;
            }
        return len + s.length() - oddCount + (oddCount > 0 ? 1 : 0);
    }
}
