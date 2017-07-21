package binary_watch;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(1));
    }

    public List<String> readBinaryWatch(int num) {
        List<String> r = new LinkedList<>();
        for (int h = 0; h < 12; h++) {
            int hOn = Integer.bitCount(h);
            if (hOn > num) continue;
            for (int m = 0; m < 60; m++) {
                int mOn = hOn + Integer.bitCount(m);
                if (mOn == num) {
                    StringBuilder b = new StringBuilder().append(h).append(":");
                    if (m < 10)
                        b.append(0).append(m);
                    else b.append(m);
                    r.add(b.toString());
                }
            }
        }
        return r;
    }
}
