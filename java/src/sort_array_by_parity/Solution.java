package sort_array_by_parity;
public class Solution {
    public int[] sortArrayByParity(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; ) {
            if (a[i] % 2 == 0)
                i++;
            else {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                j--;
            }
        }
        return a;
    }
}
