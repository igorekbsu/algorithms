package count_binary_substrings;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countBinarySubstrings("00110011"));
    }

    public int countBinarySubstrings(String s) {
        int prevLen = 0, currLen = 1, r = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1))
                currLen++;
            else {
                prevLen = currLen;
                currLen = 1;
            }
            if (prevLen >= currLen) r++;
        }
        return r;
    }
}
