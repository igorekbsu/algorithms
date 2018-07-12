package smallest_rectangle_enclosing_black_pixels;
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int minCol = image[0].length, maxCol = 0, minRow = image.length, maxRow = 0;
        for(int i = 0; i < image.length; i++)
            for(int j = 0; j < image[0].length; j++)
                if(image[i][j] == '1'){
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                }
        return (maxCol - minCol)*(maxRow - minRow);
    }
}
