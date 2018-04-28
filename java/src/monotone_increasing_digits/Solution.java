package monotone_increasing_digits;
public class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] a = String.valueOf(n).toCharArray();
        int i = a.length;
        for (int j = i - 1; j > 0; j--)
            if (a[j - 1] > a[j]) {
                i = j;
                a[j - 1] = (char) (a[j - 1] - 1);
            }
        for(int j = i; j < a.length; j++)
            a[j] = '9';
        return Integer.parseInt(new String(a));
    }
}
