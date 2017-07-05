package frac_to_decimal;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(2, 11));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder b = new StringBuilder();
        b.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        b.append(num / den);
        num %= den;
        if (num == 0) return b.toString();
        b.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, b.length());
        while (num != 0) {
            num *= 10;
            b.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                b.insert(index, "(");
                b.append(")");
                break;
            } else
                map.put(num, b.length());
        }
        return b.toString();
    }
}