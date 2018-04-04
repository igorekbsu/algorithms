package lonely_pixel_I;
import java.util.BitSet;

public class Solution {
    public static void main(String[] args) {
        char[][] p = {{'W', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'W'}};
        System.out.println(new Solution().findLonelyPixel(p));
    }

    public int findLonelyPixel(char[][] p) {
        BitSet[] rows = new BitSet[p.length], cols = new BitSet[p[0].length];
        for (int i = 0; i < p.length; i++)
            rows[i] = new BitSet(p[0].length);
        for (int i = 0; i < p[0].length; i++)
            cols[i] = new BitSet(p.length);
        for (int i = 0; i < p.length; i++)
            for (int j = 0; j < p[0].length; j++)
                if (p[i][j] == 'B') {
                    rows[i].set(j, true);
                    cols[j].set(i, true);
                }
        int count = 0;
        for (int i = 0; i < p.length; i++)
            if (rows[i].cardinality() == 1) {
                int j = rows[i].nextSetBit(0);
                if (cols[j].cardinality() == 1 && cols[j].nextSetBit(0) == i)
                    count++;
            }
        return count;
    }
}
