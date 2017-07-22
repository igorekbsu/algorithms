package median_two_sorted_arrays;
public class Solution {
    public static void main(String[] args) {
        int[] A = {10, 12, 30, 32, 66};
        int[] B = {12, 21, 25, 36, 40, 49, 50, 91};
        System.out.println(new Solution().findMedianSortedArrays(A, B));//32
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m > n) return findMedianSortedArrays(B, A);
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2, j = halfLen - i;
            if (i < m && B[j - 1] > A[i])
                imin = i + 1;
            else if (i > 0 && A[i - 1] > B[j])
                imax = i - 1;
            else {
                int maxLeft, minRight;
                if (i == 0)
                    maxLeft = B[j - 1];
                else if (j == 0)
                    maxLeft = A[i - 1];
                else maxLeft = Math.max(B[j - 1], A[i - 1]);
                if ((m + n) % 2 == 1)
                    return maxLeft;
                if (i == m)
                    minRight = B[j];
                else if (j == n)
                    minRight = A[i];
                else minRight = Math.min(A[i], B[j]);
                return (maxLeft + minRight) / 2.0;
            }
        }
        throw new IllegalArgumentException();
    }
}
