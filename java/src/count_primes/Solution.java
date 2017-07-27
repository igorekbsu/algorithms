package count_primes;
public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++)
            if (!notPrimes[i]) {
                count++;
                for (int j = 2, p = 0; p < n; j++) {
                    notPrimes[p] = true;
                    p = i * j;
                }
            }
        return count;

    }
}
