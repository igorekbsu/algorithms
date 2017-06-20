/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int m = (hi - lo) / 2 + lo;
            if (!isBadVersion(m)) lo = m + 1;
            else hi = m;
        }
        return lo;
    }

    boolean isBadVersion(int version) {return false;}
}