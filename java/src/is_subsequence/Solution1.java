package is_subsequence;
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("aee", "yyaayyee"));
    }
    public boolean isSubsequence(String s, String t) {
        char sArray[] = s.toCharArray();
        int temp = 0;
        for (char say : sArray) {
            if (t.indexOf(say) >= temp) {
                temp = t.indexOf(say);
            } else {
                return false;
            }
        }
        return true;
    }
}
