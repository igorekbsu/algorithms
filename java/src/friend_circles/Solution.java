package friend_circles;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int findCircleNum(int[][] m) {
        boolean[] marked = new boolean[m.length];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m.length; i++)
            if (!marked[i]) {
                count++;
                dfs(m, i, marked);
            }
        return count;
    }

    void dfs(int[][] m, int f, boolean[] marked) {
        for (int i = 0; i < m.length; i++)
            if (m[f][i] == 1 && !marked[i]) {
                marked[i] = true;
                dfs(m, i, marked);
            }
    }
}
