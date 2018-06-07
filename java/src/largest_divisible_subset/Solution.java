package largest_divisible_subset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] a) {
        int n = a.length, count[] = new int[n], pre[] = new int[n];
        Arrays.sort(a);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] % a[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        List<Integer> r = new ArrayList<>();
        while (index != -1) {
            r.add(a[index]);
            index = pre[index];
        }
        return r;
    }
}
