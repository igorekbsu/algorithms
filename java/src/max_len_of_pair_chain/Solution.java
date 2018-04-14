package max_len_of_pair_chain;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override public int compare(int[] p1, int[] p2) {
                return p1[0] - p2[0];
            }
        });
        int len = 1, p[] = pairs[0];
        for (int i = 1; i < pairs.length; i++)
            if (p[1] < pairs[i][0]) {
                len++;
                p = pairs[i];
            } else if (p[1] > pairs[i][1])
                p = pairs[i];
        return len;
    }
}
