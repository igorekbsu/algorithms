package rectangle_area;
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = Math.max(A, E), y1 = Math.max(B, F);
        int x2 = Math.min(C, G), y2 = Math.min(D, H);
        int common = 0;
        if (x1 <= x2 && y1 <= y2)
            common = (x2 - x1) * (y2 - y1);
        return (C - A) * (D - B) + (G - E) * (H - F) - common;
    }
}
