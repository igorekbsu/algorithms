package palindromic_substrings;
public class Solution {
    public int countSubstrings(String s) {
        char[] a = s.toCharArray();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            count += expand(a, i, i + 1);
            count += expand(a, i, i);
        }
        return count;
    }

    int expand(char[] a, int left, int right) {
        int count = 0;
        while (left >= 0 && right < a.length && a[left--] == a[right++])
            count++;
        return count;
    }
}
