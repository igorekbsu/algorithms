package reorganize_str;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("vvvlo"));
    }

    public String reorganizeString(String S) {
        int[] counts = new int[26];
        int max = Integer.MIN_VALUE;
        for (char c : S.toCharArray()) {
            counts[c - 'a']++;
            max = Math.max(max, counts[c - 'a']);
        }
        if (max > (S.length() + 1) / 2) return "";
        StringBuilder r = new StringBuilder();
        int lastUsed = -1;
        while (true) {
            int maxIndex = -1, maxCount = 0;
            for (int i = 0; i < counts.length; i++)
                if (counts[i] > 0 && counts[i] >= maxCount && i != lastUsed) {
                    maxCount = counts[i];
                    maxIndex = i;
                }
            if (maxIndex == -1) break;
            lastUsed = maxIndex;
            r.append((char) ('a' + lastUsed));
            counts[lastUsed]--;
        }
        return r.toString();
    }
}
