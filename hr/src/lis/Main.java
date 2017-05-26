package lis;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int[] p = new int[a.length];
        int[] m = new int[a.length + 1];
        int L = 0;
        for (int i = 0; i < a.length; i++) {
            int lo = 1, hi = L;
            while (lo <= hi) {
                int mid = (int) Math.ceil((lo + hi) / 2.0);
                if (a[m[mid]] < a[i])
                    lo = mid + 1;
                else hi = mid - 1;
            }
            int newL = lo;
            p[i] = m[newL - 1];
            m[newL] = i;
            L = Math.max(newL, L);
        }
        int[] s = new int[L];
        int k = m[L];
        for (int i = L - 1; i >= 0; i--) {
            s[i] = a[k];
            k = p[k];
        }
        System.out.println(Arrays.toString(s));
    }
}
