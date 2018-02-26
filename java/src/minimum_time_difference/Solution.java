package minimum_time_difference;
import java.util.List;

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[24 * 60];
        int minIndex = Integer.MAX_VALUE;
        for (String tp : timePoints) {
            int h = Integer.parseInt(tp.substring(0, 2));
            int i = h * 60 + Integer.parseInt(tp.substring(3));
            if (minutes[i]) return 0;
            minIndex = Math.min(minIndex, i);
            minutes[i] = true;
        }
        int min = Integer.MAX_VALUE, j = minIndex;
        for (int i = j + 1; i < minutes.length; i++)
            if (minutes[i]) {
                min = Math.min(min, i - j);
                j = i;
            }
        return Math.min(min, minutes.length - j + minIndex + 1);
    }
}
