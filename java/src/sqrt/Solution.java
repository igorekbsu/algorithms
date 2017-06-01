package sqrt;
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(9));
    }

    public int mySqrt(int x) {
        int lo = 1, hi = x;
        while (true) {
            int mid = lo + (hi - lo) / 2;
            if (mid > x / mid)
                hi = mid - 1;
            else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                else lo = mid + 1;
            }
        }
    }
}
