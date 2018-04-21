package int_to_roman;
public class Solution {
    public String intToRoman(int n) {
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String s[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < vals.length && n > 0; i++)
            while (n >= vals[i]) {
                r.append(s[i]);
                n -= vals[i];
            }
        return r.toString();
    }
}
