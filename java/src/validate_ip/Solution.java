package validate_ip;
public class Solution {
  public static void main(String[] args) {
    System.out.println(new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
  }

  public String validIPAddress(String IP) {
    String neither = "Neither", v4 = "IPv4", v6 = "IPv6";
    if (IP.startsWith(".") || IP.endsWith(".") || IP.startsWith(":") || IP.endsWith(":"))
      return neither;
    if (IP.contains(".")) {
      String[] parts = IP.split("\\.");
      if (parts.length != 4) return neither;
      for (String p : parts) {
        if (p.length() == 0) return neither;
        if (p.charAt(0) == '0' && p.length() > 1) return neither;
        int n = 0;
        for (int c : p.toCharArray()) {
          if (!Character.isDigit(c)) return neither;
          n = 10 * n + c - '0';
        }
        if (n < 0 || n > 255) return neither;
      }
      return v4;
    } else if (IP.contains(":")) {
      String[] parts = IP.split(":");
      if (parts.length != 8) return neither;
      for (String p : parts) {
        if (p.length() == 0 || p.length() > 4) return neither;
        for (char c : p.toCharArray()) {
          if (c >= '0' && c <= '9') continue;
          if (c >= 'a' && c <= 'f') continue;
          if (c >= 'A' && c <= 'F') continue;
          return neither;
        }
      }
      return v6;
    }
    return neither;
  }
}
