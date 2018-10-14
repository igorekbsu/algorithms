package sort_array_by_parity_II;
public class Solution {
    public int[] sortArrayByParityII(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0, even = 0, odd = 1; i < a.length; i++)
            if (a[i] % 2 == 0) {
                b[even] = a[i];
                even += 2;
            } else {
                b[odd] = a[i];
                odd += 2;
            }
        return b;
    }
}
