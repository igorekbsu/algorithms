package histogram_largest_rectangle;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{1}));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        Stack<Rec> s = new Stack<>();
        s.add(new Rec(0, 0));
        int max = 0;
        for (int h : heights) {
            Rec current = new Rec(h, 1), top = s.peek();
            if (top.h < current.h) {
                s.add(current);
            } else if (top.h == current.h) {
                top.w++;
            } else {
                int width = 0;
                while (top.h > current.h) {
                    s.pop();
                    width += top.w;
                    max = Math.max(max, top.h * width);
                    top = s.peek();
                }
                current.w += width;
                s.add(current);
            }
        }
        while (s.peek().h != 0) {
            Rec top = s.pop();
            max = Math.max(max, top.h * top.w);
            s.peek().w += top.w;

        }
        return max;
    }

    class Rec {
        int h, w;

        Rec(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
