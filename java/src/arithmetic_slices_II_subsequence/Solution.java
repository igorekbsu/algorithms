package arithmetic_slices_II_subsequence;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
    }

    public int numberOfArithmeticSlices(int[] a) {
        int r = 0;
        Item[] items = new Item[a.length];
        for (int i = 0; i < a.length; i++) {
            items[i] = new Item();
            for (int j = 0; j < i; j++) {
                long diff = (long) a[i] - a[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
                    continue;
                int d = (int) diff;
                int c1 = items[i].m.getOrDefault(d, 0);
                int c2 = items[j].m.getOrDefault(d, 0);
                r += c2;
                items[i].m.put(d, c1 + c2 + 1);
            }
        }
        return r;
    }

    class Item {
        Map<Integer, Integer> m = new HashMap<>();
    }
}
