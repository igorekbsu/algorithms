package trap_rain_water;
public class Solution {
    public int trap(int[] height) {
        int maxLeft = 0, maxRight = 0, trapped = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                trapped += maxLeft - height[left++];
            } else {
                maxRight = Math.max(maxRight, height[right]);
                trapped += maxRight - height[right--];
            }
        }
        return trapped;
    }
}
