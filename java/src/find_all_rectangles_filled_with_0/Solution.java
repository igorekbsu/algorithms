package find_all_rectangles_filled_with_0;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] m = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 1},
            {1, 1, 1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1}
        };

        List<int[]> r = new Solution().zeroRectangles(m);
        for (int[] item : r)
            System.out.println(Arrays.toString(item));
    }

    public List<int[]> zeroRectangles(int[][] m) {
        List<int[]> r = new LinkedList<>();
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                if (m[i][j] == 0) {
                    int[] item = new int[4];
                    item[0] = i; item[1] = j;
                    int x = i, y = j;
                    while (x < m.length && m[x][j] == 0)
                        x++;
                    while (y < m[0].length && m[i][y] == 0)
                        y++;
                    item[2] = x - 1; item[3] = y - 1;
                    for (int i1 = i; i1 < x; i1++)
                        for (int j1 = j; j1 < y; j1++)
                            m[i1][j1] = -1;
                    r.add(item);
                }
        return r;
    }
}
