package snake_and_ladders;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().get(11, 4));
        System.out.println(new Solution().snakesAndLadders(new int[][]{{4, -1}, {-1, 3}}));
    }

    public int snakesAndLadders(int[][] b) {
        int N = b.length;
        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(1, 0);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int s = q.remove();
            if (s == N * N)
                return dist.get(s);
            for (int s2 = s + 1; s2 <= Math.min(s + 6, N * N); ++s2) {
                int rc = get(s2, N);
                int r = rc / N, c = rc % N;
                int s2Final = b[r][c] == -1 ? s2 : b[r][c];
                if (!dist.containsKey(s2Final)) {
                    dist.put(s2Final, dist.get(s) + 1);
                    q.add(s2Final);
                }
            }
        }
        return -1;
    }

    public int get(int s, int N) {
        // Given a square num s, return board coordinates (r, c) as r*N + c
        int quot = (s - 1) / N;
        int rem = (s - 1) % N;
        int row = N - 1 - quot;
        int col = row % 2 != N % 2 ? rem : N - 1 - rem;
        return row * N + col;
    }
}
