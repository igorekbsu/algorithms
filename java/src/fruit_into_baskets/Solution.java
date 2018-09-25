package fruit_into_baskets;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().totalFruit(new int[]{2, 1, 2}));
    }

    public int totalFruit(int[] a) {
        int i = 0, maxFruit = 0;
        while (i < a.length) {
            Set<Integer> baskets = new HashSet<>();
            int fruit = 0, nextIdx = 0;
            for (int j = i; j < a.length; j++) {
                if (baskets.add(a[j]))
                    if (baskets.size() > 2)
                        break;
                fruit++;
                if (a[j] != a[i] && nextIdx == 0)
                    nextIdx = j;
            }
            maxFruit = Math.max(maxFruit, fruit);
            if (nextIdx == 0) break;
            i = nextIdx;
            if (maxFruit >= a.length - nextIdx) break;
        }
        return maxFruit;
    }
}
