package array_manipulation;
public class Solution {
    public static void main(String[] args) {
        System.out.println(arrayManipulation(10, new int[][]{
            {2, 6, 8},
            {3, 5, 7},
            {1, 8, 1},
            {5, 9, 15}
        }));
    }

    static long arrayManipulation(int n, int[][] queries) {
        long max = 0, a[] = new long[n + 2];
        for (int[] q : queries) {
            a[q[0]] += q[2];
            a[q[1] + 1] -= q[2];
        }
        long sum = 0;
        for (long e : a) {
            sum += e;
            max = Math.max(max, sum);
        }
        return max;
    }                                               
}
