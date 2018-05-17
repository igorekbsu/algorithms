package plus_one;
public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9)
            digits[i--] = 0;
        if (i < 0) {
            int[] r = new int[digits.length + 1];
            r[0] = 1;
            return r;
        } else {
            digits[i] += 1;
            return digits;
        }
    }
}
