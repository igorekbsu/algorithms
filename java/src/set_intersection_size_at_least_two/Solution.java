package set_intersection_size_at_least_two;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[][] a = {
            {4, 14},
            {6, 17},
            {7, 14},
            {14, 21},
            {4, 7}
        };
        System.out.println(new Solution().intersectionSizeTwo(a));
    }

    public int intersectionSizeTwo(int[][] a) {
        Arrays.sort(a, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int maxMax = -1, max = -1, r = 0;
        for (int[] i : a) {
            int start = i[0], end = i[1];
            if (maxMax < start) {
                r += 2;
                maxMax = end;
                max = end - 1;
            } else if (max < start) {
                r++;
                max = maxMax == end ? maxMax - 1 : maxMax;
                maxMax = end;
            }
        }
        return r;
    }
}
