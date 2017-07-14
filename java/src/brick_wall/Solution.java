package brick_wall;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 2, 1},
                {3, 1, 2},
                {1, 3, 2},
                {2, 4},
                {3, 1, 2},
                {1, 3, 1, 1}};
        List<List<Integer>> wall = new LinkedList<>();
        for (int[] row : a) {
            List<Integer> list = new LinkedList<>();
            for (int i : row)
                list.add(i);
            wall.add(list);
        }
        System.out.println(new Solution().leastBricks(wall));
    }

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (List<Integer> row : wall)
            for (int i = 0, sum = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(max, map.get(sum));
            }
        return wall.size() - max;
    }
}
