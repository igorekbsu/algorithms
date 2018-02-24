package can_i_win;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canIWin(1, 50));
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        Map<Integer, Boolean> cache = new HashMap<>();
        return canWin(maxChoosableInteger, desiredTotal, 0, cache);
    }

    boolean canWin(int max, int total, int used, Map<Integer, Boolean> cache) {
        if (total <= 0) return false;
        if (cache.containsKey(used))
            return cache.get(used);
        for (int i = 1; i <= max; i++) {
            int bit = 1 << i;
            if ((bit & used) == 0) {
                if (!canWin(max, total - i, used | bit, cache)) {
                    cache.put(used, true);
                    return true;
                }
            }
        }
        cache.put(used, false);
        return false;
    }
}
