import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
            len = Math.max(len, i - start);
            while (map.size() > 2) {
                Integer count = map.get(s.charAt(start)) - 1;
                if (count == 0) map.remove(s.charAt(start));
                else map.put(s.charAt(start), count);
                start++;
            }
        }
        if (map.size() <= 2)
            len = Math.max(len, s.length() - start);
        return len;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            while (map.size() > k) {
                Integer count = map.get(a[start]) - 1;
                if (count == 0) map.remove(a[start]);
                else map.put(a[start], count);
                start++;
            }
            len = Math.max(len, i - start + 1);
        }
        return len;
    }
}
