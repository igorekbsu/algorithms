package create_max_number;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a1 = {3, 4, 6, 5};
        int[] a2 = {9, 1, 2, 5, 8, 3};
        System.out.println(Arrays.toString(new Solution().maxNumber(a1, a2, 5)));
    }

    public int[] maxNumber(int[] a1, int[] a2, int k) {
        int[] r = new int[k];
        for (int len = 0; len <= Math.min(a1.length, k); len++)
            if (k - len <= a2.length) {
                int[] n1 = max(a1, len);
                int[] n2 = max(a2, k - len);
                int[] n = merge(n1, n2);
                if (greater(n, 0, r, 0))
                    r = n;
            }
        return r;
    }

    boolean greater(int[] a1, int i1, int[] a2, int i2) {
        int i = 0;
        while (i1 < a1.length && i2 < a2.length && a1[i1] == a2[i2]) {
            i1++; i2++;
        }
        return i2 == a2.length || (i1 < a1.length && a1[i1] > a2[i2]);
    }

    int[] merge(int[] a1, int[] a2) {
        int[] r = new int[a1.length + a2.length];
        for (int i1 = 0, i2 = 0, i = 0; i < r.length; i++)
            r[i] = greater(a1, i1, a2, i2) ? a1[i1++] : a2[i2++];
        return r;
    }

    int[] max(int[] a, int k) {
        int[] r = new int[k];
        ArrayDeque<Integer> s = new ArrayDeque<>(a.length);
        for (int i = 0; i < a.length; i++) {
            while (!s.isEmpty() && s.peek() < a[i] && s.size() + a.length - i > k)
                s.pop();
            s.push(a[i]);
        }
        for (int i = 0; i < k; i++)
            r[i] = s.pollLast();
        return r;
    }
}
