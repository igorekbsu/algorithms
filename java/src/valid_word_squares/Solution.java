package valid_word_squares;
import java.util.List;

public class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.get(0).length(); i++) {
            StringBuilder vertical = new StringBuilder();
            for (String w : words)
                if (i >= w.length()) break;
                else vertical.append(w.charAt(i));
            if (!vertical.toString().equals(words.get(i)))
                return false;
        }
        return true;
    }
}
