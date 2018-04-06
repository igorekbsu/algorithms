package missing_chars_to_make_pangram;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().missingChars("The quick brown fox jumps over the lazy do"));
        System.out.println(new Solution().missingChars("my name is Igor"));
    }

    public String missingChars(String s) {
        boolean[] used = new boolean[26];
        for (char c : s.toCharArray()) {
            int p = Character.toLowerCase(c) - 'a';
            if (p < 26 && p >=0)
                used[p] = true;
        }
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < used.length; i++)
            if (!used[i])
                r.append((char) (i + 'a'));
        return r.toString();
    }
}
