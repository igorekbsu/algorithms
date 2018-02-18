package range_addition;
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] r = new int[length];
        for (int[] u : updates) {
            r[u[0]] += u[2];
            if (u[1] < length - 1)
                r[u[1] + 1] -= u[2];
        }
        for (int i = 1; i < length; i++)
            r[i] += r[i - 1];
        return r;
    }
}
