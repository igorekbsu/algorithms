package rectangle_overlap;
public class Solution {
    public boolean isRectangleOverlap(int[] r1, int[] r2) {
        if (r1[2] <= r2[0]) return false;
        if (r1[3] <= r2[1]) return false;
        if (r2[2] <= r1[0]) return false;
        if (r2[3] <= r1[1]) return false;
        return true;
    }
}
