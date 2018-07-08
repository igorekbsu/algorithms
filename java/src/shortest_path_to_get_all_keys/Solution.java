package shortest_path_to_get_all_keys;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String[] g = {
            "@.a.#",
            "###.#",
            "b.A.B"
        };
        System.out.println(new Solution().shortestPathAllKeys(g));
    }

    public int shortestPathAllKeys(String[] g) {
        State start = null;
        int allKeys = 0, dir[] = {-1, 0, 1, 0, -1}, steps = 0, n = g.length, m = g[0].length();
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                a[i][j] = g[i].charAt(j);
                if (a[i][j] == '@')
                    start = new State(i, j, 0);
                else if (Character.isLowerCase(a[i][j]))
                    allKeys |= 1 << (a[i][j] - 'a');
            }
        Queue<State> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.offer(start);
        seen.add(start.id);
        while (!q.isEmpty()) {
            steps++;
            for (int size = q.size(); size > 0; size--) {
                State state = q.poll();
                for (int k = 1; k < dir.length; k++) {
                    int i = state.r + dir[k - 1], j = state.c + dir[k], keys = state.keys;
                    if (i < 0 || i >= n || j < 0 || j >= m || a[i][j] == '#') continue;
                    if (Character.isUpperCase(a[i][j]) && (keys & (1 << (a[i][j] - 'A'))) == 0) continue;
                    if (Character.isLowerCase(a[i][j]))
                        keys |= 1 << (a[i][j] - 'a');
                    if (keys == allKeys)
                        return steps;
                    State nextState = new State(i, j, keys);
                    if (seen.add(nextState.id))
                        q.offer(nextState);
                }
            }
        }
        return -1;
    }

    class State {
        final int r, c, keys;
        final String id;

        State(int r, int c, int keys) {
            this.r = r; this.c = c; this.keys = keys;
            id = r + "," + c + "," + keys;
        }
    }
}
