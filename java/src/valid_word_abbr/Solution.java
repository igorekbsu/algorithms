package valid_word_abbr;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().validWordAbbreviation("internationalization", "i12iz4n"));
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        char[] a = abbr.toCharArray(), s = word.toCharArray();
        for (int j = 0, i = 0, n = 0; j <= a.length; j++) {
            if (j == a.length)
                return i + n == s.length;
            else if (Character.isDigit(a[j])) {
                n = 10 * n + a[j] - '0';
                if (n == 0) return false;
            } else {
                i += n;
                if (i >= s.length || a[j] != s[i]) return false;
                n = 0;
                i++;
            }
        }
        return false;
    }
}
