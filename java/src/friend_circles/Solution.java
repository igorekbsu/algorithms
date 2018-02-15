package friend_circles;
public class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] inCircle = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++)
            if (!inCircle[i]) {
                inCircle[i] = true;
                dfs(M, i, inCircle);
                count++;
            }
        return count;
    }

    void dfs(int[][] m, int i, boolean[] visited) {
        for (int j = 0; j < m.length; j++)
            if (m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(m, j, visited);
            }
    }
}
