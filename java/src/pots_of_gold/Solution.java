package pots_of_gold;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        int[] a = {8, 1000, 3, 2};
        System.out.println(maxCoins(a, 4));
    }

    public static int maxCoins(int[] A, int n) {
        Map<Key, Integer> cache = new HashMap<>();
        return mc(A, 0, A.length - 1, cache);
    }

    static int mc(int[] pots, int left, int right, Map<Key, Integer> cache) {
        Key key = new Key(left, right);
        if (cache.containsKey(key))
            return cache.get(key);
        if (left > right) return 0;
        int A = pots[left] + Math.min(mc(pots, left + 2, right, cache), mc(pots, left + 1, right - 1, cache));
        int B = pots[right] + Math.min(mc(pots, left + 1, right - 1, cache), mc(pots, left, right - 2, cache));
        int R = Math.max(A, B);
        cache.put(key, R);
        return R;
    }

    static class Key {
        int i, j;

        Key(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key index = (Key) o;
            return i == index.i && j == index.j;
        }

        @Override public int hashCode() { return Objects.hash(i, j); }
    }
}
