package line_reflection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[][] points = {{0, 0}};
        System.out.println(new Solution().isReflected(points));
    }

    public boolean isReflected(int[][] points) {
        Set<Integer> s = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] p : points) {
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
            s.add(Objects.hash(p[0], p[1]));
        }
        int x = min + max;
        for (int[] p : points)
            if(!s.contains(Objects.hash(x - p[0],p[1])))
                return false;
        return true;
    }
}
