package shortest_unsorted_continuous_subarray;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[]{2, 3, 3, 2, 4}));
    }

    public int findUnsortedSubarray1(int[] a) {
        int N = a.length, left = -1, right = -2, min = a[N - 1], max = a[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[N - 1 - i]);
            if (a[i] < max) right = i;
            if (a[N - i - 1] > min) left = N - i - 1;
        }
        return right - left + 1;
    }

    public int findUnsortedSubarray(int[] a) {
        int[] b = a.clone();
        Arrays.sort(b);
        int left = -1, right = -2;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (left == -1) left = i;
                right = i;
            }
        }
        return right - left + 1;
    }
}
