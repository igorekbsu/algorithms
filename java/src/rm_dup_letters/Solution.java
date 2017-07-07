package rm_dup_letters;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        int[] f = new int[26];
        for (int i = 0; i < s.length(); i++)
            f[s.charAt(i) - 'a']++;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(k)) k = i;
            if (--f[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(k) + removeDuplicateLetters(s.substring(k + 1).replaceAll(String.valueOf(s.charAt(k)), ""));
    }
}
