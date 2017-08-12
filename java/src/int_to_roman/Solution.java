package int_to_roman;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(20));
    }

    public String intToRoman(int n) {
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder r = new StringBuilder();
        while (n > 0)
            for (int i = 0; i < ints.length; i++)
                if (n >= ints[i]) {
                    r.append(romans[i]);
                    n -= ints[i];
                    break;
                }
        return r.toString();
    }
}
