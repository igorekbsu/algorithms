package split_array_with_same_average;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

    public boolean splitArraySameAverage(int[] a) {
        if (a.length < 2)
            return false;
        int sumA = 0;
        Arrays.sort(a);
        for (int n : a) sumA += n;
        for (int lenB = 1; lenB <= a.length / 2; lenB++)
            if ((sumA * lenB) % a.length == 0)
                if (check(a, (sumA * lenB) / a.length, lenB, 0))
                    return true;
        return false;
    }

    boolean check(int[] A, int sumB, int lenB, int sIndex) {
        if (lenB == 0) return sumB == 0;
        if (A[sIndex] > sumB / lenB) return false;
        for (int i = sIndex; i < A.length - lenB + 1; i++)
            if (i > sIndex && A[i] == A[i - 1])
                continue;
            else if (check(A, sumB - A[i], lenB - 1, i + 1))
                return true;
        return false;
    }

}
