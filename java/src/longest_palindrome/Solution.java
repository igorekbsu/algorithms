package longest_palindrome;
public class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return s;
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        for (int i = 0; i < chars.length; i++) {
            int len = palindrome(chars, i, i);
            len = Math.max(len, palindrome(chars, i, i + 1));
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    int palindrome(char[] chars, int j, int i) {
        while (j >= 0 && i < chars.length && chars[i] == chars[j]) {
            j--; i++;
        }
        return i - j - 1;
    }
}
