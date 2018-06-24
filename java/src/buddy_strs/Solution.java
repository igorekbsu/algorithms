package buddy_strs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        List<Integer> d = new ArrayList<>();
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                d.add(i);
            else s.add(a.charAt(i));
        if (d.size() == 0 && s.size() < a.length()) return true;
        return d.size() == 2 && a.charAt(d.get(0)) == b.charAt(d.get(1)) && a.charAt(d.get(1)) == b.charAt(d.get(0));
    }
}
