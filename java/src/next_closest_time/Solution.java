package next_closest_time;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().nextClosestTime("23:59"));
    }

    public String nextClosestTime(String t) {
        int h = 10 * (t.charAt(0) - '0') + t.charAt(1) - '0';
        int m = 10 * (t.charAt(3) - '0') + t.charAt(4) - '0';
        int used = (1 << h / 10) | (1 << h % 10) | (1 << m / 10) | (1 << m % 10);
        while (true) {
            m = m + 1 == 60 ? 0 : m + 1;
            if (m == 0)
                h = h + 1 == 24 ? 0 : h + 1;
            int current = (1 << h / 10) | (1 << h % 10) | (1 << m / 10) | (1 << m % 10);
            if ((used & current) == current)
                return String.format("%02d:%02d", h, m);
        }
    }
}
