package generalized_abbreviation;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println("0".substring(1));
        System.out.println(new Solution().generateAbbreviations("igor"));
    }

    public List<String> generateAbbreviations(String word) {
        List<String> r = new ArrayList<>();
        gen(word, "", r, false);
        return r;
    }

    void gen(String word, String pre, List<String> r, boolean number) {
        if (word.length() == 0)
            r.add(pre);
        else {
            gen(word.substring(1), pre + word.charAt(0), r, false);
            if (!number)
                for (int j = 1; j <= word.length(); j++)
                    gen(word.substring(j), pre + j, r, true);
        }
    }
}
