package comp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String[] grid = {
            "@...a",
            ".###A",
            "b.BCc"
        };
//        String[] grid = {
//            "@..aA"
//        };
        System.out.println(new Solution().shortestPathAllKeys(grid));
    }

    int[] dirs = {-1, 0, 1, 0, -1};
    int minPath = Integer.MAX_VALUE;

    public int shortestPathAllKeys(String[] grid) {
        char[][] a = new char[grid.length][grid[0].length()];
        int startI = 0, startJ = 0, keyCount = 0;
        Set<Character> keysList = new HashSet<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length(); j++) {
                a[i][j] = grid[i].charAt(j);
                if (a[i][j] == '@') {
                    startI = i;
                    startJ = j;
                    a[i][j] = '.';
                } else if ('a' <= a[i][j] && a[i][j] <= 'z')
                    keysList.add(a[i][j]);
            }
        Set<Character> keys = new HashSet<>();
        path(startI, startJ, keys, a, keysList, 0);
        return minPath == Integer.MAX_VALUE ? -1 : minPath;
    }

    void path(int startI, int startJ, Set<Character> keys, char[][] a, Set<Character> leftKeys, int steps) {
        if (minPath < steps) return;
        if (keys.size() == leftKeys.size()) {
            minPath = Math.min(steps, minPath);
        }
        for (char key : leftKeys) {
            if (!keys.contains(key)) {
                boolean[][] seen = new boolean[a.length][a[0].length];
                seen[startI][startJ] = true;
                Queue<Path> q = new LinkedList<>();
                q.offer(new Path(startI, startJ));
                int d = 0;
                boolean done = false;
                while (!q.isEmpty()) {
                    d++;
                    for (int size = q.size(); size > 0; size--) {
                        Path path = q.poll();
                        int r = path.r, c = path.c;
                        for (int k = 1; k < dirs.length; k++) {
                            int nr = r + dirs[k - 1], nc = c + dirs[k];
                            if (0 <= nr && nr < a.length && 0 <= nc && nc < a[0].length && a[nr][nc] != '#' && !seen[nr][nc]) {
                                if (a[nr][nc] == key) {
                                    keys.add(key);
                                    path(nr, nc, keys, a, leftKeys, steps + d);
                                    keys.remove(key);
                                    done = true;
                                } else if (a[nr][nc] == '.' || leftKeys.contains(a[nr][nc]) || keys.contains(Character.toLowerCase(a[nr][nc]))) {
                                    Path e = new Path(nr, nc);
                                    if (leftKeys.contains(a[nr][nc])) {
                                        e.keys.addAll(keys);
                                        e.keys.add(a[nr][nc]);
                                    }
                                    seen[nr][nc] = true;
                                    q.offer(e);
                                }
                            }
                        }
                    }
                    if (done)
                        break;
                }
            }
        }
    }

    class Path {
        Set<Character> keys = new HashSet<>();
        int r, c;

        public Path(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
