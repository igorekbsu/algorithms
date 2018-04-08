package two_keys_keyboard;
public class Solution {
    public int minSteps(int n) {
        int r = 0;
        for (int i = 2; i <= n; i++)
            while (n % i == 0) {
                n /= i;
                r += i;
            }
        return r;
    }
}
