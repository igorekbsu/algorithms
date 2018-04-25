package shortest_distance_to_char;
public class Solution {
    public int[] shortestToChar(String s, char c) {
        int r[] = new int[s.length()];
        for (int i = 0, d = s.length(); i < s.length(); i++, d++) {
            if (s.charAt(i) == c)
                d = 0;
            r[i] = d;
        }
        for (int i = s.length() - 1, d = s.length(); i >= 0; i--, d++) {
            if (s.charAt(i) == c)
                d = 0;
            r[i] = Math.min(r[i], d);
        }
        return r;
    }
}
