package histogram_largest_rectangle;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{1}));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        Stack<int[]> s = new Stack<>();
        s.add(new int[]{0, 0});
        int max = 0;
        for (int h : heights) {
            int[] current = new int[]{h, 1}, top = s.peek();
            if (top[0] < current[0]) {
                s.add(current);
            } else if (top[0] == current[0]) {
                top[1]++;
            } else {
                int width = 0;
                while (top[0] > current[0]) {
                    s.pop();
                    width += top[1];
                    max = Math.max(max, top[0] * width);
                    top = s.peek();
                }
                current[1] += width;
                s.add(current);
            }
        }
        while (s.peek()[0] != 0) {
            int[] top = s.pop();
            max = Math.max(max, top[0] * top[1]);
            s.peek()[1] += top[1];
        }
        return max;
    }
}
