package valid_word_abbr;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().validWordAbbreviation("hi", "2i"));
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, n = 0;
        for (char c : abbr.toCharArray()) {
            if (c == '0' && n == 0)
                return false;
            if (Character.isDigit(c))
                n = 10 * n + c - '0';
            else {
                i += n;
                n = 0;
                if (i >= word.length() || word.charAt(i) != c)
                    return false;
                i++;
            }
        }
        return i + n == word.length();
    }
}
