package pascals_triangle;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> r = new ArrayList<>(rowIndex + 1);
        r.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--)
                r.set(j, r.get(j - 1) + r.get(j));
            r.add(1);
        }
        return r;
    }
}
