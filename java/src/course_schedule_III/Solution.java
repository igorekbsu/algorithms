package course_schedule_III;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override public int compare(int[] c1, int[] c2) {
                return c1[1] - c2[1];
            }
        });
        int lastEnd = 0, count = 0;
        for (int[] c : courses)
            if (lastEnd + c[0] <= c[1]) {
                count++;
                lastEnd += c[0];
            }
        return count;
    }
}
