package find_permutation;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findPermutation("DDD")));
    }

    public int[] findPermutation(String ss) {
        int s = 1, n = 1, r[] = new int[ss.length() + 1], i = 0;
        for (char c : ss.toCharArray())
            if (c == 'D')
                n++;
            else {
                for (int a = n; a >= s; a--)
                    r[i++] = a;
                s = ++n;
            }
        for (int a = n; a >= s; a--)
            r[i++] = a;
        return r;
    }
}
