package permutation_in_str;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("hello", "ooolleoooleh"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int f[] = new int[26], lo = 0, hi = 0, count = s1.length();
        for (char c : s1.toCharArray())
            f[c - 'a']++;
        char[] a = s2.toCharArray();
        while (hi < a.length) {
            if (f[a[hi] - 'a'] > 0) {
                f[a[hi] - 'a']--;
                count--;
            } else {
                while (a[lo] != a[hi]) {
                    f[a[lo++] - 'a']++;
                    count++;
                }
                lo++;
            }
            if (count == 0) return true;
            hi++;
        }
        return false;
    }
}
