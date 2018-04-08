package lexicographical_numbers;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> r = new ArrayList<>(n + 1);
        for (int i = 0, curr = 1; i < n; i++) {
            r.add(curr);
            if (curr * 10 <= n)
                curr *= 10;
            else {
                while (curr % 10 == 9 || curr == n)
                    curr /= 10;
                curr++;
            }
        }
        return r;
    }
}
