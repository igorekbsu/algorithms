package mult_strings;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123", "54"));
    }

    public String multiply(String a, String b) {
        int m = a.length(), n = b.length();
        int[] product = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + product[p2];
                product[p1] += sum / 10;
                product[p2] = (sum) % 10;
            }
        }
        StringBuilder r = new StringBuilder();
        for (int p : product)
            if (!(p == 0 && r.length() == 0)) r.append(p);
        return r.length() > 0 ? r.toString() : "0";
    }
}