package first_uniq_char;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("leetcode"));
        System.out.println(new Solution().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        int mask = 0, dup = 0;
        char[] a = s.toCharArray();
        for (int c : a) {
            int bit = 1 << (c - 'a');
            if ((mask & bit) != 0)
                dup |= bit;
            else
                mask |= bit;
        }
        for (int i = 0; i < a.length; i++)
            if ((dup & ((1 << a[i] - 'a'))) == 0)
                return i;
        return -1;
    }
}
