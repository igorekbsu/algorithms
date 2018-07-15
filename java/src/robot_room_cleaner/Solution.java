package robot_room_cleaner;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int[][] g = {
            {1, 0, 1},
            {1, 1, 1},
            {0, 1, 1},
            {1, 1, 0}
        };
        Robot r = new Robot(g, 0, 0);
        new Solution().cleanRoom(r);
        r.print();
    }

    public void cleanRoom(Robot robot) { clean(robot, new HashSet<>(), 0, 0, 0);}

    void clean(Robot robot, Set<String> seen, int row, int col, int dir) {
        String position = row + ":" + col;
        if (!seen.add(position)) return;
        robot.clean();
        for (int n = 0; n < 4; n++) {
            if (robot.move()) {
                int r = row, c = col;
                if (dir == 0)
                    r -= 1;
                else if (dir == 1)
                    c += 1;
                else if (dir == 2)
                    r += 1;
                else c -= 1;
                clean(robot, seen, r, c, dir);
                robot.turnLeft(); robot.turnLeft();
                robot.move();
                robot.turnRight(); robot.turnRight();
            }
            robot.turnRight();
            dir = (dir + 1) % 4;
        }
    }

    static class Robot {
        final int[][] g;
        final boolean[][] seen;
        int row, col, dir;

        Robot(int[][] g, int r, int c) {
            this.g = g;
            seen = new boolean[g.length][g[0].length];
            row = r; col = c;
        }

        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move() {
            int r = row, c = col;
            if (dir == 0)
                r -= 1;
            else if (dir == 1)
                c += 1;
            else if (dir == 2)
                r += 1;
            else if (dir == 3)
                c -= 1;
            if (r < 0 || r >= g.length || c < 0 || c >= g[0].length) return false;
            row = r;
            col = c;
            return true;
        }

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft() { dir = Math.floorMod(dir - 1, 4);}

        public void turnRight() { dir = Math.floorMod(dir + 1, 4);}

        public void clean() { seen[row][col] = true;}

        public void print() {
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[0].length; j++) {
                    if (g[i][j] == 0)
                        System.out.print(0);
                    else if (g[i][j] == 1)
                        System.out.print(seen[i][j] ? 1 : 2);
                }
                System.out.println();
            }

        }
    }
}