package text_justification;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> strings = new Solution().fullJustify(words, 16);
        for (String string : strings)
            System.out.println(string);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
       List<String> r = new LinkedList<>();
       return r;
    }
}
