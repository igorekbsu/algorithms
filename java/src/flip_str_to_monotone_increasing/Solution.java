package flip_str_to_monotone_increasing;
public class Solution {
    public int minFlipsMonoIncr(String s) {
        int flip = 0, ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                if (ones == 0)
                    continue;
                else flip++;
            else ones++;
            if (flip > ones)
                flip = ones;
        }
        return flip;
    }
}