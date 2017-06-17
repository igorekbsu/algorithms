package add_binary;
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder r = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int c = carry;
            if (i >= 0) c += a.charAt(i) - '0';
            if (j >= 0) c += b.charAt(j) - '0';
            carry = c / 2;
            r.append(c % 2);
        }
        if (carry > 0) r.append(carry);
        return r.reverse().toString();
    }
}
