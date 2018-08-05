package multiply_strings;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        char[] a1 = num1.toCharArray(), a2 = num2.toCharArray();
        int[] r = new int[a1.length + a2.length];
        for (int i = a1.length - 1; i >= 0; i--)
            for (int j = a2.length - 1; j >= 0; j--) {
                int mult = (a1[i] - '0') * (a2[j] - '0');
                int p1 = j + i, p2 = j + i + 1;
                mult += r[p2];
                r[p1] += mult / 10;
                r[p2] = mult % 10;
            }
        StringBuilder s = new StringBuilder();
        for (int n : r)
            if (!(s.length() == 0 && n == 0))
                s.append(n);
        return s.length() == 0 ? "0" : s.toString();
    }
}
