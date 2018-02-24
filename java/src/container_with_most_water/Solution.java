package container_with_most_water;
public class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int h = Math.min(height[i], height[j]);
            area = Math.max(area, (j - i) * h);
            while (height[i] <= h && i < j) i++;
            while (height[j] <= h && i < j) j--;
        }
        return area;
    }
}
