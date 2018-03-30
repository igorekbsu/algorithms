package design_phone_directory;
import java.util.BitSet;

public class Solution {
    class PhoneDirectory {
        final BitSet s;
        final int N;

        public PhoneDirectory(int maxNumbers) {
            N = maxNumbers;
            s = new BitSet(N);
        }

        public int get() {
            int n = s.nextClearBit(0);
            if (n == N) return -1;
            s.flip(n);
            return n;
        }

        public boolean check(int number) { return !s.get(number);}

        public void release(int number) { s.clear(number);}
    }
}
