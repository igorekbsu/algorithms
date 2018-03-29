package rectangle_area;
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E), right = Math.min(G, C);
        int bottom = Math.max(B, F), top = Math.min(D, H);
        int common = 0;
        if (right > left && top > bottom)
            common = (right - left) * (top - bottom);
        return (C - A) * (D - B) + (G - E) * (H - F) - common;
    }
}
