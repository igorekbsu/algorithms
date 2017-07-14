package text_justification;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {""};
        List<String> strings = new Solution().fullJustify(words, 2);
        for (String string : strings)
            System.out.println(string);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> r = new LinkedList<>();
        for (int left = 0, right; left < words.length; left = right) {
            int len = -1;
            for (right = left; right < words.length && len + 1 + words[right].length() <= maxWidth; right++)
                len += 1 + words[right].length();
            StringBuilder b = new StringBuilder(words[left]);
            int space = 1, extra = 0;
            if (right != left + 1 && right != words.length) {
                space = (maxWidth - len) / (right - left - 1) + 1;
                extra = (maxWidth - len) % (right - left - 1);
            }
            for (int j = left + 1; j < right; j++) {
                for (int k = 0; k < space; k++)
                    b.append(' ');
                if (extra-- > 0)
                    b.append(' ');
                b.append(words[j]);
            }
            int strLen = maxWidth - b.length();
            while (strLen-- > 0)
                b.append(' ');
            r.add(b.toString());
        }
        return r;
    }
}
