package reverse_pairs;
import java.util.Arrays;

public class Solution {
    public int reversePairs(int[] nums) {
        int r = 0, copy[] = Arrays.copyOf(nums, nums.length), bit[] = new int[copy.length + 1];
        Arrays.sort(copy);
        for (int ele : nums) {
            r += search(bit, index(copy, 2L * ele + 1));
            insert(bit, index(copy, ele));
        }
        return r;
    }

    int index(int[] a, long val) {
        int l = 0, r = a.length - 1, m;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (a[m] >= val)
                r = m - 1;
            else l = m + 1;
        }
        return l + 1;
    }

    int search(int[] bit, int i) {
        int sum = 0;
        while (i < bit.length) {
            sum += bit[i];
            i += i & -i;
        }
        return sum;
    }

    void insert(int[] bit, int i) {
        while (i > 0) {
            bit[i] += 1;
            i -= i & -i;
        }
    }
}
