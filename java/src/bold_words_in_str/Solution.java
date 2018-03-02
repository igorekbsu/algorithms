package bold_words_in_str;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().boldWords(new String[]{"ab", "bcd"}, "abcd"));
    }

    public String boldWords(String[] words, String S) {
        boolean[] bold = new boolean[S.length() + 1];
        for (String w : words) {
            int start = S.indexOf(w, 0);
            while (start != -1) {
                Arrays.fill(bold, start, start + w.length(), true);
                start = S.indexOf(w, start + 1);
            }
        }
        StringBuilder r = new StringBuilder().append(bold[0] ? "<b>" : "");
        for (int i = 0; i < bold.length - 1; i++) {
            r.append(S.charAt(i));
            if (!bold[i] && bold[i + 1]) r.append("<b>");
            else if (bold[i] && !bold[i + 1]) r.append("</b>");
        }
        return r.toString();
    }
}
