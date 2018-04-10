package trapping_rain_water;
public class Solution {
    public int trap(int[] h) {
        int maxL = 0, maxR = 0, water = 0, left = 0, right = h.length - 1;
        while (left < right)
            if (h[left] <= h[right]) {
                maxL = Math.max(maxL, h[left]);
                water += maxL - h[left++];
            } else {
                maxR = Math.max(maxR, h[right]);
                water += maxR - h[right--];
            }
        return water;
    }
}
