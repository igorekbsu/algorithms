package k_empty_slots;
import java.util.TreeSet;

public class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            Integer lo = s.floor(flowers[i]), hi = s.ceiling(flowers[i]);
            if ((lo != null && flowers[i] - lo - 1 == k) || (hi != null && hi - flowers[i] - 1 == k))
                return i + 1;
            s.add(flowers[i]);
        }
        return -1;
    }
}
