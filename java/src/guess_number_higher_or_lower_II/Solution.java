package guess_number_higher_or_lower_II;
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] m = new int[n + 1][n + 1];
        return money(1, n, m);
    }

    int money(int lo, int hi, int[][] m) {
        if (lo >= hi) return 0;
        if(m[lo][hi] > 0)return m[lo][hi];
        int r = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            int money = i + Math.max(money(lo, i - 1, m), money(i + 1, hi, m));
            r = Math.min(r, money);
        }
        m[lo][hi] = r;
        return r;
    }
}
