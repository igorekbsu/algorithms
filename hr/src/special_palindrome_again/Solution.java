package special_palindrome_again;
public class Solution {
    public static void main(String[] args) {
        System.out.println(substrCount(4, "aaaa"));
    }

    static long substrCount(int n, String s) {
        long count = 0;
        char[] a = s.toCharArray();
        for (int i = 1; i < n - 1; i++) {
            if (a[i] != a[i - 1] && a[i + 1] != a[i]) {
                int lo = i - 1, hi = i + 1;
                while (lo >= 0 && hi < n && a[lo] == a[i - 1] && a[hi] == a[i - 1]) {
                    count++;
                    lo--;
                    hi++;
                }
            }
        }
        long step = 1;
        for (int i = 0, j = 0; i < n; i++)
            if (a[i] == a[j]) {
                count += step;
                step++;
            } else {
                count += 1;
                step = 1;
                j = i;
            }

        return count;
    }
}
