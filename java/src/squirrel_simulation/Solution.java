package squirrel_simulation;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance(5, 7, new int[]{2, 2}, new int[]{4, 4}, new int[][]{{3, 0}, {0, 6}}));
    }

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int maxSaved = Integer.MIN_VALUE, distance = 0;
        for (int[] nut : nuts) {
            int nut2s = Math.abs(nut[0] - squirrel[0]) + Math.abs(nut[1] - squirrel[1]);
            int nut2t = Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1]);
            if (nut2t - nut2s > maxSaved)
                maxSaved = nut2t - nut2s;
            distance += 2 * nut2t;
        }
        return distance - maxSaved;
    }
}
