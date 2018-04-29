package min_number_of_arrows_to_burst_baloons;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++)
            if (points[i][0] > end) {
                end = points[i][1];
                count++;
            }
        return count;
    }
}
