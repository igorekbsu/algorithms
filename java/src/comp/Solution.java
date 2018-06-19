package comp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        int[] p = {10, 8, 0, 5, 3};
        int[] s = {2, 4, 1, 1, 3};
        System.out.println(new Solution().carFleet(12, p, s));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int[][] c = new int[speed.length][2];
        for (int i = 0; i < speed.length; i++)
            c[i] = new int[]{target - position[i], speed[i]};
        Arrays.sort(c, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        TreeSet<Double> s = new TreeSet<>();
        for (int i = 0; i < c.length; i++) {
            double time = (1.0 * c[i][0]) / c[i][1];
            if (s.isEmpty())
                s.add(time);
            else if (time > s.last())
                s.add(time);
        }
        return s.size();
    }
}
