package rearrange_str_k_distance_apart;
public class Solution {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26], valid = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        char[] r = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int nextIndex = -1, maxCount = 0;
            for (int j = 0; j < count.length; j++)
                if (count[j] > maxCount && valid[j] <= i) {
                    maxCount = count[j];
                    nextIndex = j;
                }
            if (nextIndex == -1) return "";
            r[i] = (char)(nextIndex + 'a');
            count[nextIndex]--;
            valid[nextIndex] = i + k;
        }
        return new String(r);
    }
}
