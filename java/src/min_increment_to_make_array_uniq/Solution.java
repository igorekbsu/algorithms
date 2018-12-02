package min_increment_to_make_array_uniq;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minIncrementForUnique(new int[]{0}));
    }

    public int minIncrementForUnique(int[] a) {
        int moves = 0, next = 0;
        Arrays.sort(a);
        for (int n : a) {
            if (n > next)
                next = n;
            else moves += next - n;
            next++;
        }
        return moves;
    }
}
