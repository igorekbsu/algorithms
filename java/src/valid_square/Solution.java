package valid_square;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};
        System.out.println(new Solution().validSquare(p1, p2, p3, p4));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] lens = {len(p1, p2), len(p1, p3), len(p1, p4), len(p2, p3), len(p2, p4), len(p3, p4)};
        Set<Long> s = new HashSet<>();
        for (long len : lens)
            if (len == 0) return false;
            else s.add(len);
        return s.size() == 2;
    }

    long len(int[] p1, int[] p2) {
        int x = p1[0] - p2[0], y = p1[1] - p2[1];
        return x * x + y * y;
    }
}
