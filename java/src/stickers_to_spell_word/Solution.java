package stickers_to_spell_word;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minStickers(new String[]{"with", "example", "science"}, "thehat"));
    }

    public int minStickers(String[] stickers, String target) {
        int[][] stickersF = new int[stickers.length][26];
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < stickers.length; i++)
            for (char c : stickers[i].toCharArray())
                stickersF[i][c - 'a']++;
        dp.put("", 0);
        return min(stickersF, target, dp);
    }

    int min(int[][] stickersF, String target, Map<String, Integer> dp) {
        if (dp.containsKey(target)) return dp.get(target);
        if (target.isEmpty()) return 0;
        int targetF[] = new int[26], r = Integer.MAX_VALUE;
        for (char c : target.toCharArray())
            targetF[c - 'a']++;
        for (int[] stickerF : stickersF) {
            if (stickerF[target.charAt(0) - 'a'] == 0) continue;
            StringBuilder newTarget = new StringBuilder();
            for (int i = 0; i < 26; i++)
                for (int count = targetF[i] - stickerF[i]; count > 0; count--)
                    newTarget.append((char) ('a' + i));
            int min = 1 + min(stickersF, newTarget.toString(), dp);
            if (min >= 0)
                r = Math.min(r, min);
        }
        dp.put(target, r);
        return r == Integer.MAX_VALUE ? -1 : r;
    }
}
