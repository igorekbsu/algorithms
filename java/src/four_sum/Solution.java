package four_sum;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] a, int target) {
        List<List<Integer>> r = new LinkedList<>();
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (i == 0 || a[i - 1] != a[i])
                for (int j = i + 1; j < a.length; j++)
                    if (j == i + 1 || a[j - 1] != a[j]) {
                        int lo = j + 1, hi = a.length - 1;
                        while (lo < hi) {
                            int sum = a[i] + a[j] + a[lo] + a[hi];
                            if (sum == target) {
                                r.add(Arrays.asList(a[i], a[j], a[lo++], a[hi--]));
                                while (lo < hi && a[lo] == a[lo - 1]) lo++;
                                while (lo < hi && a[hi] == a[hi + 1]) hi--;
                            } else if (sum > target)
                                hi--;
                            else lo++;
                        }
                    }
        }
        return r;
    }
}
