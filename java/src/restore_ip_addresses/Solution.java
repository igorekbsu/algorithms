package restore_ip_addresses;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("010010"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> r = new LinkedList<>();
        restore(s, r, new ArrayList<>(), 4);
        return r;
    }

    void restore(String s, List<String> r, List<Integer> ip, int bytes) {
        if (bytes == 0) {
            if (s.length() == 0) {
                StringBuilder b = new StringBuilder().append(ip.get(0));
                for (int i = 1; i < ip.size(); i++)
                    b.append('.').append(ip.get(i));
                r.add(b.toString());
            }
        } else {
            bytes -= 1;
            for (int i = 1; i <= Math.min(s.length(), 3); i++) {
                String first = s.substring(0, i);
                if (first.length() > 1 && first.charAt(0) == '0') continue;
                int d = Integer.parseInt(first);
                String rest = s.substring(i);
                if (d < 256 && rest.length() >= bytes && rest.length() <= bytes * 3) {
                    ip.add(d);
                    restore(rest, r, ip, bytes);
                    ip.remove(ip.size() - 1);
                }
            }
        }
    }
}
