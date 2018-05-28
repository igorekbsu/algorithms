package contain_virus;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] g = {
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1}
        };
        System.out.println(new Solution().containVirus(g));
    }

    int walls = 0, dirs[] = {-1, 0, 1, 0, -1};

    public int containVirus(int[][] g) {
        List<Area> areas = new LinkedList<>();
        Area maxArea = new Area(-1, -1);
        boolean[][] seen = new boolean[g.length][g[0].length];
        for (int i = 0; i < g.length; i++)
            for (int j = 0; j < g[0].length; j++)
                if (g[i][j] == 1 && !seen[i][j]) {
                    Area area = new Area(i, j);
                    dfs(i, j, g, area, seen);
                    for (int[] ij : area.toInfect)
                        seen[ij[0]][ij[1]] = false;
                    if (maxArea.toInfect.size() < area.toInfect.size())
                        maxArea = area;
                    areas.add(area);
                }
        if (maxArea.i == -1)
            return walls;
        countWalls(maxArea.i, maxArea.j, g);
        for (Area area : areas)
            if (area != maxArea)
                for (int[] ij : area.toInfect)
                    g[ij[0]][ij[1]] = 1;
        return containVirus(g);
    }

    class Area {
        final int i, j;
        List<int[]> toInfect = new LinkedList<>();

        Area(int r, int c) {i = r; j = c;}
    }

    void countWalls(int i, int j, int[][] g) {
        g[i][j] = -1;
        for (int d = 1; d < dirs.length; d++) {
            int r = i + dirs[d - 1], c = j + dirs[d];
            if (r >= 0 && r < g.length && c >= 0 && c < g[0].length)
                if (g[r][c] == 0)
                    walls++;
                else if (g[r][c] == 1)
                    countWalls(r, c, g);
        }
    }

    void dfs(int i, int j, int[][] g, Area area, boolean[][] seen) {
        seen[i][j] = true;
        for (int d = 1; d < dirs.length; d++) {
            int r = i + dirs[d - 1], c = j + dirs[d];
            if (r >= 0 && r < g.length && c >= 0 && c < g[0].length) {
                if (g[r][c] == 0) {
                    if (!seen[r][c])
                        area.toInfect.add(new int[]{r, c});
                    seen[r][c] = true;
                } else if (g[r][c] == 1 && !seen[r][c])
                    dfs(r, c, g, area, seen);
            }
        }
    }
}