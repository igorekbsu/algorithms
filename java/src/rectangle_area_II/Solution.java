package rectangle_area_II;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
//        int[][] recs = {
//            {0, 0, 2, 2},
//            {1, 0, 2, 3},
//            {1, 0, 3, 1}
//        };
        int[][] recs = {
            {1, 0, 2, 4},
            {1, 3, 6, 6}
        };
        System.out.println(new Solution().rectangleArea(recs));
    }

    public int rectangleArea(int[][] rectangles) {
        Set<Integer> xVals = new HashSet<>();
        Set<Integer> yVals = new HashSet<>();
        for (int[] rec : rectangles) {
            xVals.add(rec[0]);
            xVals.add(rec[2]);
            yVals.add(rec[1]);
            yVals.add(rec[3]);
        }
        Integer[] listX = xVals.toArray(new Integer[0]);
        Arrays.sort(listX);
        Integer[] listY = yVals.toArray(new Integer[0]);
        Arrays.sort(listY);
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        for (int i = 0; i < listX.length; ++i)
            mapX.put(listX[i], i);
        for (int i = 0; i < listY.length; ++i)
            mapY.put(listY[i], i);
        boolean[][] grid = new boolean[listX.length][listY.length];
        for (int[] rec : rectangles)
            for (int x = mapX.get(rec[0]); x < mapX.get(rec[2]); ++x)
                for (int y = mapY.get(rec[1]); y < mapY.get(rec[3]); ++y)
                    grid[x][y] = true;
        long r = 0;
        for (int x = 0; x < grid.length; ++x)
            for (int y = 0; y < grid[0].length; ++y)
                if (grid[x][y])
                    r += (long) (listX[x + 1] - listX[x]) * (listY[y + 1] - listY[y]);
        r %= 1_000_000_007;
        return (int) r;
    }
}
