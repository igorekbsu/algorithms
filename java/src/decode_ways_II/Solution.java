package decode_ways_II;
public class Solution {
    public int numDecodings1(String s) {
        int MOD = (int) (1e9 + 7);
        long endingAny = 1, ending1 = 0, ending2 = 0;
        for (char c : s.toCharArray()) {
            long curEndingAny;
            if (c == '*') {
                curEndingAny = 9 * endingAny + 9 * ending1 + 6 * ending2;
                ending1 = endingAny;
                ending2 = endingAny;
            } else {
                curEndingAny = (c == '0' ? 0 : endingAny) + ending1 + (c <= '6' ? ending2 : 0);
                ending1 = (c == '1' ? endingAny : 0);
                ending2 = (c == '2' ? endingAny : 0);
            }
            endingAny = curEndingAny % MOD;
        }
        return (int) endingAny;
    }
}
