package falling_squares;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] p = {{1, 2}, {2, 3}, {6, 1}};
        System.out.println(new Solution().fallingSquares(p));
    }

    public List<Integer> fallingSquares(int[][] pos) {
        List<Interval> intervals = new ArrayList<>(pos.length);
        List<Integer> r = new ArrayList<>(pos.length);
        int maxHeight = 0;
        for (int[] p : pos) {
            Interval curr = new Interval(p[0], p[0] + p[1] - 1, p[1]);
            int h = 0;
            for (Interval i : intervals)
                if (curr.end < i.start || i.end < curr.start) continue;
                else h = Math.max(h, i.h);
            curr.h += h;
            intervals.add(curr);
            maxHeight = Math.max(maxHeight, curr.h);
            r.add(maxHeight);
        }
        return r;
    }

    class Interval {
        int start, end, h;

        Interval(int start, int end, int h) {
            this.start = start;
            this.end = end;
            this.h = h;
        }
    }
}
