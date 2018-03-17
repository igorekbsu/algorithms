package sentence_screen_fitting;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().wordsTyping(new String[]{"hello"}, 100, 1));
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int len = 0, count = 0, totalRowCount = 0;
        Map<Integer, int[]> dp = new HashMap<>();
        while (true) {
            if (dp.get(len) != null) {
                len = dp.get(len)[0];
                totalRowCount += dp.get(len)[1];
            } else {
                int prevLen = len, prevRowCount = totalRowCount;
                for (String word : sentence) {
                    if (word.length() > cols) return 0;
                    if (len + word.length() > cols) {
                        len = 0;
                        totalRowCount++;
                        if (totalRowCount >= rows)
                            return count;
                    }
                    len += word.length() + 1;
                    dp.put(prevLen, new int[]{len, totalRowCount - prevRowCount});
                }
            }
            count++;
        }
    }
}
