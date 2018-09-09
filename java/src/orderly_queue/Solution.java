package orderly_queue;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().orderlyQueue("xisxr", 1));
    }
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            return new String(a);
        }
        String r = s;
        for (int i = 1; i < s.length(); i++) {
            String t = s.substring(i) + s.substring(0, i);
            if (t.compareTo(r) < 0)
                r = t;
        }
        return r;
    }
}
