package comp;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167));
    }

    public int shortestSubarray(int[] a, int k) {
        int currSum = 0, minLen = a.length + 1;
        int lo = 0, hi = 0;
        while (hi < a.length) {
            while (currSum < k && hi < a.length) {
                if (currSum < 0) {
                    lo = hi;
                    currSum = 0;
                }
                currSum += a[hi++];
            }
            while (lo < a.length) {
                if (currSum>=k && hi - lo < minLen)
                    minLen = hi - lo;
                currSum -= a[lo++];
            }
        }
        return minLen > a.length ? -1 : minLen;
    }
}
