package flip_game;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> r = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 1; i < s.length(); i++)
            if (chars[i - 1] == '+' && chars[i] == '+') {
                chars[i - 1] = chars[i] = '-';
                r.add(new String(chars));
                chars[i - 1] = chars[i] = '+';
            }
        return r;
    }
}
