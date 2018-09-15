package rle_iterator;
public class Solution {
    class RLEIterator {
        int a[], i;

        public RLEIterator(int[] a) { this.a = a;}

        public int next(int n) {
            for (; i < a.length; i += 2)
                if (n > a[i])
                    n -= a[i];
                else {
                    a[i] -= n;
                    return a[i + 1];
                }
            return -1;
        }
    }
}
