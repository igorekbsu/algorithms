package convex_polygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isConvex(
            new ArrayList<>(Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(0, 1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 0))
            )));
    }

    public boolean isConvex(List<List<Integer>> points) {
        points.add(points.get(0));
        points.add(points.get(1));
        int orient = 0;
        for (int i = 2; i < points.size(); i++) {
            int currOrient = orient(points.get(i - 2), points.get(i - 1), points.get(i));
            if (currOrient == 0) continue;
            if (orient == 0)
                orient = currOrient;
            else if ((long) orient * currOrient < 0)
                return false;
        }
        return true;
    }

    int orient(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
        return (p2.get(1) - p1.get(1)) * (p3.get(0) - p2.get(0)) - (p3.get(1) - p2.get(1)) * (p2.get(0) - p1.get(0));
    }
}
