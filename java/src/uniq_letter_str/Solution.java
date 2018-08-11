package uniq_letter_str;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().uniqueLetterString("ABA"));
    }

    public int uniqueLetterString(String s) {
        char[] a = s.toCharArray();
        long sum = 0;
        for (int n = s.length(), i = 0, l = 0, r = 0; i < n; i++) {
            for (l = i - 1; l >= 0 && a[l] != a[i]; l--) ;
            for (r = i + 1; r < n && a[r] != a[i]; r++) ;
            sum += (r - i) * (i - l);
        }
        return (int) (sum % 1_000_000_007);
    }
}
