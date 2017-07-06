package max_xor_of_two;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] a = {14, 11, 7, 2, 12};
        System.out.println(new Solution().findMaximumXOR(a));
    }

    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 3; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
