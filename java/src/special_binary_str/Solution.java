package special_binary_str;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().makeLargestSpecial("11011000"));
    }

    public String makeLargestSpecial(String s) {
        if (s.length() == 0) return s;
        int start = 0, bal = 0;
        List<String> mountains = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            bal += s.charAt(i) == '1' ? 1 : -1;
            if (bal == 0) {
                mountains.add("1" + makeLargestSpecial(s.substring(start + 1, i)) + "0");
                start = i + 1;
            }
        }
        Collections.sort(mountains, Collections.reverseOrder());
        return String.join("", mountains);
    }
}
