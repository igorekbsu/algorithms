package monotonic_array;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isMonotonic(new int[]{1, 2, 4, 5}));
    }

    public boolean isMonotonic(int[] a) {
        int sign = 0;
        for (int i = 1; i < a.length; i++) {
            int currSign = Integer.signum(a[i - 1] - a[i]);
            if (currSign != 0) {
                if (sign == 0)
                    sign = currSign;
                else if (sign != currSign)
                    return false;
            }
        }
        return true;
    }
}
