package find_all_anagrams_in_str;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("abcabc", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> r = new LinkedList<>();
        if (p.length() > s.length()) return r;
        Map<Character, Integer> f = new HashMap<>();
        for (int i = 0; i < p.length(); i++)
            execute(f, p.charAt(i), s.charAt(i));
        if (f.isEmpty()) r.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            execute(f, s.charAt(i - p.length()), s.charAt(i));
            if(f.isEmpty())
                r.add(i - p.length() + 1);
        }
        return r;
    }

    void execute(Map<Character, Integer> f, char add, char rm) {
        f.put(add, f.getOrDefault(add, 0) + 1);
        f.put(rm, f.getOrDefault(rm, 0) - 1);
        if (f.get(add) == 0)
            f.remove(add);
        if (f.getOrDefault(rm, 1) == 0)
            f.remove(rm);
    }
}
