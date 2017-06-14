package screen_fit;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().wordsTyping(new String[]{"me", "hi"}, 2, 2));
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        Map<Integer, Integer> map = new HashMap<>();
        int num = 0, n = sentence.length;
        for (int r = 0; r < rows; r++) {
            int start = num % n;
            if (map.get(start) == null) {
                int cnt = 0, len = 0;
                for (int i = start; len < cols; i = (i + 1) % n, cnt++) {
                    if (len + sentence[i].length() > cols)
                        break;
                    len += sentence[i].length() + 1;
                }
                num += cnt;
                map.put(start, cnt);
            } else
                num += map.get(start);
        }
        return num / n;
    }
}