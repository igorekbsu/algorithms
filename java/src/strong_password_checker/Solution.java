package strong_password_checker;
public class Solution {
    public int strongPasswordChecker(String s) {
        int res = 0, a = 1, A = 1, d = 1;
        char[] carr = s.toCharArray();
        int[] arr = new int[carr.length];
        for (int i = 0; i < arr.length; ) {
            if (Character.isLowerCase(carr[i]))
                a = 0;
            if (Character.isUpperCase(carr[i]))
                A = 0;
            if (Character.isDigit(carr[i]))
                d = 0;
            int j = i;
            while (i < carr.length && carr[i] == carr[j])
                i++;
            arr[j] = i - j;
        }
        int totalMissing = a + A + d;
        if (arr.length < 6)
            res += totalMissing + Math.max(0, 6 - (arr.length + totalMissing));
        else {
            int overLen = Math.max(arr.length - 20, 0), leftOver = 0;
            res += overLen;
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < arr.length && overLen > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != (k - 1)) continue;
                    arr[i] -= Math.min(overLen, k);
                    overLen -= k;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 3 && overLen > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= overLen;
                    overLen -= need;
                }
                if (arr[i] >= 3) leftOver += arr[i] / 3;
            }
            res += Math.max(totalMissing, leftOver);
        }
        return res;
    }
}
