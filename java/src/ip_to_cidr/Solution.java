package ip_to_cidr;
import java.util.LinkedList;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    System.out.println(new Solution().ipToCIDR("255.0.0.8", 20));
  }

  public List<String> ipToCIDR(String IP, int range) {
    long x = 0;
    String[] parts = IP.split("\\.");
    for (String part : parts)
      x = Integer.parseInt(part) + x * 256;
    List<String> r = new LinkedList<>();
    while (range > 0) {
      int step = (int) (x & -x);
      while (step > range) step /= 2;
      r.add(longToIP(x, step));
      x += step;
      range -= step;
    }
    return r;
  }

  String longToIP(long x, int step) {
    int[] r = new int[4];
    r[0] = (int) (x & 255); x >>= 8;
    r[1] = (int) (x & 255); x >>= 8;
    r[2] = (int) (x & 255); x >>= 8;
    r[3] = (int) x;
    int len = 33;
    while (step > 0) {
      len--;
      step /= 2;
    }
    return r[3] + "." + r[2] + "." + r[1] + "." + r[0] + "/" + len;
  }
}
