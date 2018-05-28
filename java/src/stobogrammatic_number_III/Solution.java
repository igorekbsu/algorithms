package stobogrammatic_number_III;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        List<String> all = new LinkedList<>();
        for (int len = low.length(); len <= high.length(); len++)
            all.addAll(findStrobogrammatic(len));
        int count = 0;
        for (String s : all)
            if (s.length() == low.length() && s.compareTo(low) < 0 || (s.length() == high.length() && s.compareTo(high) > 0)) continue;
            else count++;
        return count;
    }

    List<String> findStrobogrammatic(int n) {
        List<String> curr, r = new ArrayList<>(n % 2 == 0 ? Arrays.asList("") : Arrays.asList("0", "1", "8"));
        if (n < 2) return r;
        for (; n > 1; n -= 2) {
            curr = r;
            r = new LinkedList<>();
            for (String i : curr) {
                if (n > 3)
                    r.add("0" + i + "0");
                r.add("1" + i + "1");
                r.add("6" + i + "9");
                r.add("9" + i + "6");
                r.add("8" + i + "8");
            }
        }
        return r;
    }
}
