package sort_chars_by_frequency;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("tree"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> f = new HashMap<>();
        for (char c : s.toCharArray())
            f.put(c, f.getOrDefault(c, 0) + 1);
        String[] buckets = new String[s.length() + 1];
        for (Character c : f.keySet()) {
            Integer freq = f.get(c);
            buckets[freq] = buckets[freq] == null ? c + "" : buckets[freq] + c;
        }
        StringBuilder r = new StringBuilder(s.length());
        for (int i = s.length(); i >= 0; i--)
            if (buckets[i] != null)
                for (char c : buckets[i].toCharArray())
                    for (int j = 0; j < i; j++)
                        r.append(c);
        return r.toString();
    }
}
