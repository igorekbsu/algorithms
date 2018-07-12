package next_closest_time;

public class Solution {
    public String nextClosestTime(String time) {
        char[] a = time.toCharArray();
        int h = 10 * (a[0] - '0') + a[1] - '0', m = 10 * (a[3] - '0') + a[4] - '0';
        for (int used = mask(h, m), curr = -1; (used & curr) != curr; curr = mask(h, m)) {
            m = m == 59 ? 0 : m + 1;
            if (m == 0)
                h = h == 23 ? 0 : h + 1;
        }
        return String.format("%02d:%02d", h, m);
    }

    int mask(int h, int m) { return (1 << h / 10 | 1 << h % 10 | 1 << m / 10 | 1 << m % 10);}
}
