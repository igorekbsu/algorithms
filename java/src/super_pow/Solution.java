package super_pow;
public class Solution {
    final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length);
    }

    int superPow(int a, int[] b, int len) {
        if (len == 1)
            return powMod(a, b[0]);
        return powMod(superPow(a, b, len - 1), 10) * powMod(a, b[len - 1]) % MOD;
    }

    int powMod(int x, int y) {
        x %= MOD;
        int pow = 1;
        for (int i = 0; i < y; i++)
            pow = (pow * x) % MOD;
        return pow;
    }
}
