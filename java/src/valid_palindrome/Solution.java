package valid_palindrome;
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; )
            if (!Character.isLetterOrDigit(chars[i])) i++;
            else if (!Character.isLetterOrDigit(chars[j])) j--;
            else if (Character.toLowerCase(chars[i++]) != Character.toLowerCase(chars[j--]))
                return false;
        return true;
    }
}
