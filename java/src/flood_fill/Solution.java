package flood_fill;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        int[] pairs = {1, 0, -1, 0, 1};
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.add(new int[]{sr, sc});
        while (!q.isEmpty()) {
            int[] rc = q.poll();
            for (int i = 1; i < pairs.length; i++) {
                int r = rc[0] + pairs[i - 1], c = rc[1] + pairs[i];
                if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) continue;
                image[r][c] = newColor;
                q.add(new int[]{r, c});
            }
        }
        return image;
    }
}
