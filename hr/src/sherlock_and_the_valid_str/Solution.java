package sherlock_and_the_valid_str;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("abcdefghhgfedecba"));
    }

    static String isValid(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray())
            f[c - 'a']++;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int e : f)
            if (e > 0)
                m.put(e, m.getOrDefault(e, 0) + 1);
        if (m.size() == 1) return "YES";
        if (m.size() == 2) {
            if (m.firstKey() == 1 && m.firstEntry().getValue() == 1) return "YES";
            if (m.lastKey() - m.firstKey() == 1 && m.lastEntry().getValue() == 1) return "YES";
        }
        return "NO";
    }
}
