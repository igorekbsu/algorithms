package stobogrammatic_number_II;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findStrobogrammatic(4));
    }

    public List<String> findStrobogrammatic(int n) {
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
