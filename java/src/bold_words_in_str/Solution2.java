package bold_words_in_str;
import java.util.Arrays;

public class Solution2 {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length() + 1];
        for (String w : dict) {
            int start = s.indexOf(w, 0);
            while (start != -1) {
                Arrays.fill(bold, start, start + w.length(), true);
                start = s.indexOf(w, start + 1);
            }
        }
        StringBuilder r = new StringBuilder().append(bold[0] ? "<b>" : "");
        for (int i = 0; i < bold.length - 1; i++) {
            r.append(s.charAt(i));
            if (!bold[i] && bold[i + 1]) r.append("<b>");
            else if (bold[i] && !bold[i + 1]) r.append("</b>");
        }
        return r.toString();
    }
}
