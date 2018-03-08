package escape_the_ghosts;
import java.util.Arrays;

public class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] t) {
        return Arrays.stream(ghosts).map(g -> Math.abs(g[0] - t[0]) + Math.abs(g[1] - t[1])).allMatch(d -> d > Math.abs(t[0]) + Math.abs(t[1]));
    }
}
