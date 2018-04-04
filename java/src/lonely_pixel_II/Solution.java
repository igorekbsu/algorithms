package lonely_pixel_II;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        Map<BitSet, Integer> sameRows = new HashMap<>();
        int rowLen = picture[0].length, countInCols[] = new int[rowLen];
        for (char[] pictureRow : picture) {
            BitSet row = new BitSet(rowLen);
            for (int j = 0; j < rowLen; j++)
                if (pictureRow[j] == 'B') {
                    row.flip(j);
                    countInCols[j]++;
                }
            if (row.cardinality() == N)
                sameRows.put(row, sameRows.getOrDefault(row, 0) + 1);
        }
        int r = 0;
        for (BitSet row : sameRows.keySet())
            if (sameRows.get(row) == N)
                for (int n = row.nextSetBit(0); n >= 0; n = row.nextSetBit(n + 1))
                    if (countInCols[n] == N)
                        r += N;
        return r;
    }
}
