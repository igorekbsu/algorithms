package valid_palindrome;
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().validPalindrome("ececcecd"));
    }

    public boolean validPalindrome(String s) {
        char[] a = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (a[i] != a[j])
                return isPalindrome(a, i, j - 1) || isPalindrome(a, i + 1, j);
        return true;
    }

    boolean isPalindrome(char[] a, int i, int j) {
        while (i < j)
            if (a[i++] != a[j--])
                return false;
        return true;
    }
}
