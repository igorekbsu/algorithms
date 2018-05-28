package stobogrammatic_number;
public class Solution {
    public boolean isStrobogrammatic(String s) {
        char[] a = s.toCharArray();
        for (int i = 0, j = a.length - 1; i <= j; i++, j--) {
            if (a[i] == '9' && a[j] == '6') continue;
            if (a[i] == '6' && a[j] == '9') continue;
            if (a[i] == '1' && a[j] == '1') continue;
            if (a[i] == '0' && a[j] == '0') continue;
            if (a[i] == '8' && a[j] == '8') continue;
            return false;
        }
        return true;
    }
}
