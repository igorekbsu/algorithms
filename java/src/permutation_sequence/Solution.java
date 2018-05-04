package permutation_sequence;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4, 13));
    }

    public String getPermutation(int n, int k) {
        StringBuilder r = new StringBuilder();
        ArrayList<Integer> a = new ArrayList<>(n);
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            a.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = l / fact;
            r.append(a.remove(index));
            l -= index * fact;
        }
        return r.toString();
    }
}
