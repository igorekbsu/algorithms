package friend_circles;
import java.util.LinkedList;

public class Solution1 {
    public int findCircleNum(int[][] M) {
        boolean[] inCircle = new boolean[M.length];
        int count = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < M.length; i++)
            if (!inCircle[i]) {
                count++;
                inCircle[i] = true;
                q.add(i);
                while (!q.isEmpty()) {
                    Integer f = q.poll();
                    for (int j = 0; j < M.length; j++)
                        if (M[f][j] == 1 && !inCircle[j]) {
                            inCircle[j] = true;
                            q.add(j);
                        }
                }
            }
        return count;
    }
}
