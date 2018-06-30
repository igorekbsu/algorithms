package number_of_corner_rectangles;
public class Solution {
    public int countCornerRectangles(int[][] grid) {
        int r = 0;
        for (int i = 0; i < grid.length - 1; i++)
            for (int j = i + 1; j < grid.length; j++) {
                int count = 0;
                for (int k = 0; k < grid[0].length; k++)
                    count += grid[i][k] & grid[j][k];
                r += (count - 1) * count / 2;
            }
        return r;
    }
}
