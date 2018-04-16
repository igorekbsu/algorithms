package ip_to_cidr;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().ipToCIDR("255.0.0.7", 10));
    }

    public List<String> ipToCIDR(String ip, int n) {
        long s = ipToLong(ip);
        List<String> r = new LinkedList<>();
        while (n > 0) {
            int mask = 33 - Math.min(bitLen(s & -s), bitLen(n));
            r.add(toIp(s) + "/" + mask);
            n -= 1 << (32 - mask);
            s += 1 << (32 - mask);
        }
        return r;
    }

    int bitLen(long n) {
        if (n == 0) return 1;
        int len = 0;
        while (n > 0) {
            n >>= 1;
            len++;
        }
        return len;
    }

    String toIp(long n) {
        return String.format("%s.%s.%s.%s", n >> 24, (n >> 16) % 256, (n >> 8) % 256, n % 256);
    }

    long ipToLong(String ip) {
        long r = 0;
        for (String part : ip.split("\\."))
            r = 256 * r + Integer.parseInt(part);
        return r;
    }
}
